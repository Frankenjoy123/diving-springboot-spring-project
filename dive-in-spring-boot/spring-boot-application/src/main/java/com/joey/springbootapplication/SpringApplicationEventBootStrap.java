package com.joey.springbootapplication;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/5.
 */
public class SpringApplicationEventBootStrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 分别收到 ContextRefreshedEvent PayloadApplicationEvent ContextClosedEvent
        context.addApplicationListener(event -> {
            System.out.println("收到事件: " + event.toString());
        });

        //启动上下文
        context.refresh();

        context.publishEvent("hello world");
        context.publishEvent("2018");

        context.publishEvent(new ApplicationEvent("小joey") {
        });

        //关闭上下文
        context.close();

    }
}
