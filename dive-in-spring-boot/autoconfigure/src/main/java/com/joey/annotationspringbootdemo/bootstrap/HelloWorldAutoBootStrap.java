package com.joey.annotationspringbootdemo.bootstrap;

import com.joey.annotationspringbootdemo.repository.MyRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/3.
 */
@EnableAutoConfiguration
public class HelloWorldAutoBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(HelloWorldAutoBootStrap.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        Object hello = context.getBean("helloWorld");
        System.out.println(hello);

        context.close();
    }
}
