package com.sankuai.spi;

import com.sankuai.spi.annotation.BizSpi;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SpiManager implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<Class, List<SpiBase>> spiProviderMap = new ConcurrentHashMap<>();

    private volatile boolean isLoaded = false;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(!isLoaded) {
            Map<String, Object> spiInstanceMap = event.getApplicationContext().getBeansWithAnnotation(BizSpi.class);

            for (Object spiInstance : spiInstanceMap.values()) {
                Class[] currInterfaces = AopUtils.getTargetClass(spiInstance).getInterfaces();
                Class spiInterface = currInterfaces[0];
                if (spiProviderMap.get(spiInterface) != null && spiProviderMap.get(spiInterface).size() > 0) {
                    spiProviderMap.get(spiInterface).add((SpiBase) spiInstance);
                } else {
                    List<SpiBase> spiProviderList = new ArrayList<>();
                    spiProviderList.add((SpiBase) spiInstance);
                    spiProviderMap.put(spiInterface, spiProviderList);
                }
            }

            for (List<SpiBase> spiProviderList : spiProviderMap.values()) {
                Collections.sort(spiProviderList, new SpiComparator());
            }
        }
        isLoaded = true;
    }

    public static List<SpiBase> getSpiProviderMap(Class spiInterface) {
        return spiProviderMap.get(spiInterface);
    }

}