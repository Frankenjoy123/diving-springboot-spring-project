package com.joey.annotationspringbootdemo.annotation;

import com.joey.annotationspringbootdemo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//集中化的方式，导入很多Configuration
//@Import(HelloWorldConfiguration.class) //这种比较固定,注解方式
@Import(HelloWorldConfigurationSelector.class) //这种就很弹性，编程方式
public @interface EnableHelloWorld {


}
