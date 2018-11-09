package com.joey.annotationspringbootdemo.configuration;

import com.joey.annotationspringbootdemo.annotation.EnableHelloWorld;
import com.joey.annotationspringbootdemo.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/3.
 */
@Configuration
@EnableHelloWorld //集中化的导入configuration
@ConditionalOnSystemProperty(name = "user.name",value = "zhouxiaowu")
public class HelloWorldAutoConfiguration {

}
