package com.joey.annotationspringbootdemo.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * @return the suggested component name, if any (or empty String otherwise)
     */
//    @AliasFor(annotation = Component.class)
    String value() default "";

}
