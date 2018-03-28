package com.sankuai.spi.schema;


import com.sankuai.spi.SpiBase;
import com.sankuai.spi.SpiConfig;
import com.sankuai.spi.SpiException;
import com.sankuai.spi.SpiManager;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class SpiBeanDefinition extends AbstractSpiDefintion implements FactoryBean {

    @Override
    public Object getObject() {
        return createProxy();
    }

    private Object createProxy() {
        InvocationHandler invocationHandler = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //处理Object中的方法
                String methodName = method.getName();
                if (args == null || args.length == 0) {
                    if ("toString".equals(methodName)) {
                        return target;
                    } else if ("hashCode".equals(methodName)) {
                        return target.hashCode();
                    }
                } else if (args.length == 1 && "equals".equals(methodName)) {
                    //之所以这么写是因为Spring初始化时，会调用DefaultListableBeanFactory#determinePrimaryCandidate()方法。
                    //该方法为当前bean查找满足autowired条件的bean，查找过程会调用Objet#equals()方法，因此这里的equals方法要和Object#equls()中保持一致
                    return proxy == args[0];
                }

                List<SpiBase> spiList = SpiManager.getSpiProviderMap(getObjectType());
                List combinationResult = new ArrayList();
                for (SpiBase spi : spiList) {
                    if (SpiBase.class.isInstance(spi)) {
                        if (args != null && spi.condition(args[0])) {
                            SpiConfig spiConfig = spi.config(args[0]);
                            List result;
                            try {
                                result = (List) method.invoke(spi, args);
                            } catch (InvocationTargetException e) {
                                throw e.getTargetException();
                            }
                            if (result != null) {
                                combinationResult.addAll(result);
                            }

                            if (spiConfig.isMutex()) {
                                break;
                            }
                        }
                    }
                }
                return combinationResult;
            }
        };

        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{getObjectType()}, invocationHandler);

    }

    @Override
    public Class<?> getObjectType() {
        Class<?> clazz;
        try {
            clazz = Class.forName(target);
        } catch (Exception e) {
            throw new SpiException(String.format("Class:%s not found exception", target));
        }

        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
