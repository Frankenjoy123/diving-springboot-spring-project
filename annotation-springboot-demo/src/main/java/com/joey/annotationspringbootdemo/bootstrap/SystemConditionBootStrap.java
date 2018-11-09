package com.joey.annotationspringbootdemo.bootstrap;

import com.joey.annotationspringbootdemo.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/3.
 */
public class SystemConditionBootStrap {


    @Bean
    //条件控制是否加载bean
//    @ConditionalOnSystemProperty(name = "user.name" ,value = "zhouxiaowu")
    public String helloWorld(){
        return "hello world 2018";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
            new SpringApplicationBuilder(SystemConditionBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);


//        String hello = (String) context.getBean("helloWorld");

//        System.out.println(hello);

    }



}
