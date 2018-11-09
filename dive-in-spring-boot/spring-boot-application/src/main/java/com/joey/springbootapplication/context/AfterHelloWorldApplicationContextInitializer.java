package com.joey.springbootapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/4.
 */
public class AfterHelloWorldApplicationContextInitializer implements ApplicationContextInitializer , Ordered{
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        System.out.println("after app id is : " + applicationContext.getId());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
