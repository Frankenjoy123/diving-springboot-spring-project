package com.imooc.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 视图引导类
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/10.
 */
@SpringBootApplication(scanBasePackages = "com.imooc.web")
public class SpringBootViewBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootViewBootStrap.class , args);


    }
}
