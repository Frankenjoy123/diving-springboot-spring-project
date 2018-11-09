package com.joey.springbootapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/4.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("app id is " + applicationContext.getId());
    }
}
