package com.joey.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/4.
 */
//@SpringBootApplication
public class SpringBootApplicationBootStrap {

    //run参数是一个Configuration的源
    public static void main(String[] args) {
//        SpringApplication.run(MyBootApplication.class,args);

        //A source can be: a class name, package name, or an XML resource location
        //源可以手工加多个
        Set<String> sources = new HashSet<>();
        sources.add(MyBootApplication.class.getName());

        SpringApplication app = new SpringApplication();
        app.setSources(sources);
        app.setWebApplicationType(WebApplicationType.NONE);

        ConfigurableApplicationContext context =  app.run(args);

        System.out.println(" Bean: " + context.getBean(SpringBootApplicationBootStrap.MyBootApplication.class));

    }


    //派生性，源自Configuration注解，Component注解
    @SpringBootApplication
    public static class MyBootApplication{

    }
}
