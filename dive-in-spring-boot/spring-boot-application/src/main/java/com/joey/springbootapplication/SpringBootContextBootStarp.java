package com.joey.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * SpringBootContextBootStarp
 *
 * 获取Environment {@link SpringApplication#getOrCreateEnvironment()}
 * 创建上下文 {@link SpringApplication#createApplicationContext()}
 *
 * Servlet
 * context 实现类: {@link AnnotationConfigServletWebServerApplicationContext}
 Environment 实现类:{@link org.springframework.web.context.support.StandardServletEnvironment}


 None
 context 实现类: org.springframework.context.annotation.AnnotationConfigApplicationContext
 Environment 实现类: org.springframework.core.env.StandardEnvironment
 *
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/6.
 */
@SpringBootApplication
public class SpringBootContextBootStarp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  new SpringApplicationBuilder(SpringBootContextBootStarp.class)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("context 实现类: "+context.getClass().getName());

        System.out.println("Environment 实现类: " + context.getEnvironment().getClass().getName());

        //关闭上下文
        context.close();
    }
}
