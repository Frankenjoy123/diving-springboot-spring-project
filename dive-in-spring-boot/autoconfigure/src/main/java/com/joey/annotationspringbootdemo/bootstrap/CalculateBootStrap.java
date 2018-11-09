package com.joey.annotationspringbootdemo.bootstrap;

import com.joey.annotationspringbootdemo.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 */
@SpringBootApplication(scanBasePackages = "com.joey.annotationspringbootdemo.service")
public class CalculateBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =  new SpringApplicationBuilder(CalculateBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("java8")
                .run(args);

        CalculateService calculateService = configurableApplicationContext.getBean(CalculateService.class);

        System.out.println(calculateService.calculate(1,2,3,4));
    }
}
