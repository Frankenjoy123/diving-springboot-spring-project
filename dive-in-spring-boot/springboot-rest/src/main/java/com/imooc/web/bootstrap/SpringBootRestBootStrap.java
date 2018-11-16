package com.imooc.web.bootstrap;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * spring boot rest 引导类
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/13.
 */
@SpringBootApplication(scanBasePackages = "com.imooc.web")
 public class SpringBootRestBootStrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringBootRestBootStrap.class)
                .run(args);
    }
}
