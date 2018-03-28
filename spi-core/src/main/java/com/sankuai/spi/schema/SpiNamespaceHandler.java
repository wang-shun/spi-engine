package com.sankuai.spi.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class SpiNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("node", new SpiBeanDefinitionParser(SpiBeanDefinition.class));
    }
}
