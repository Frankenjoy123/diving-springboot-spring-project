package com.joey.annotationspringbootdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 */
@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld(){
        return "hello world";
    }

}
