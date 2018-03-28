package com.sankuai.spi.schema;

import com.sankuai.spi.SpiException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

public class SpiBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    private final Class<?> beanClass;

    public SpiBeanDefinitionParser(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder builder) {

        String id = element.getAttribute("id");
        if (!StringUtils.hasText(id)) {
            throw new SpiException("functionpoint id must not be empty.");
        }

        if (parserContext.getRegistry().containsBeanDefinition(id)) {
            throw new SpiException(String.format("duplicate spring bean:%s defined.", id));
        }
        builder.addPropertyValue("id", id);

        String target = element.getAttribute("target");
        if (!StringUtils.hasText(target)) {
            throw new SpiException("functionpoint must specify an interface");
        }
        builder.addPropertyValue("target", target);

    }

    @Override
    protected Class<?> getBeanClass(Element element) {
        return beanClass;
    }

}
