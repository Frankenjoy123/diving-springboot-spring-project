package com.joey.annotationspringbootdemo.annotation;

import com.joey.annotationspringbootdemo.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1. @{@link ImportSelector}
 *
 */
public class HelloWorldConfigurationSelector implements ImportSelector {

    /**
     * 选择需要的Conguration的class进行返回
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }

}
