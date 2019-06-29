package com.joey.webfluxdemo;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * Created by xiaowu.zhou on 2019/6/28.
 */
@Component
@Scope(SCOPE_SINGLETON)
@Lazy
@Primary
@DependsOn({"hello","fff"})

//@ComponentScan(includeFilters = {})
public class DemoBean {

}
