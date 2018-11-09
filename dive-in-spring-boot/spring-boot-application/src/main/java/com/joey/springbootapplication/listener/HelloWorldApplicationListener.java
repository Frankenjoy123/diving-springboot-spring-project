package com.joey.springbootapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 *hello world {@link ApplicationListener}  监听 {@link ContextRefreshedEvent}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/5.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorld Listener app id : " + event.getApplicationContext().getId()
            + ", timestamp : " + event.getTimestamp());
    }
}
