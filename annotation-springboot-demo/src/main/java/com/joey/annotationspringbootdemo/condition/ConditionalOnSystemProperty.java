package com.joey.annotationspringbootdemo.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/3.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {

    String name();

    String value();

}
