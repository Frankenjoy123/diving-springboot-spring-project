package com.joey.annotationspringbootdemo.bootstrap;

import com.joey.annotationspringbootdemo.annotation.EnableHelloWorld;
import com.joey.annotationspringbootdemo.repository.MyRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 */
@ComponentScan("com.joey.annotationspringbootdemo.repository")
@EnableHelloWorld
public class DemoBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(DemoBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        MyRepository repository = context.getBean("myRepository", MyRepository.class);

        System.out.println(repository);

        Object o = context.getBean("mySecondRepository");
        System.out.println(o);


        Object hello = context.getBean("helloWorld");
        System.out.println(hello);

        context.close();
    }
}
