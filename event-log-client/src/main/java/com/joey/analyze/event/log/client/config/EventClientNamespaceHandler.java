package com.joey.analyze.event.log.client.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by xiaowu.zhou on 2019/6/18.
 */
public class EventClientNamespaceHandler extends NamespaceHandlerSupport{

    @Override
    public void init() {
        registerBeanDefinitionParser("config", new EventConfigBeanDefinitionParser());
    }
}
