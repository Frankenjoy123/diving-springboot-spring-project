package com.joey.springbootapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 *after hello world {@link ApplicationListener}  监听 {@link ContextRefreshedEvent}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/5.
 */
public class AfterHelloWorldApplicationListener
        implements ApplicationListener<ContextRefreshedEvent> , Ordered{

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("after HelloWorld Listener app id : " + event.getApplicationContext().getId()
            + ", timestamp : " + event.getTimestamp());
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
