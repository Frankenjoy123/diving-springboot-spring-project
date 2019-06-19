package com.joey.event.log.demo;

import com.alibaba.fastjson.JSON;
import com.joey.analyze.event.log.client.bean.EventConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by xiaowu.zhou on 2019/6/18.
 */
@SpringBootApplication
@ImportResource("classpath:spring/*")
public class SpringBootContextBootStarp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =  new SpringApplicationBuilder(SpringBootContextBootStarp.class)
                .web(WebApplicationType.NONE)
                .run(args);

        System.out.println("context 实现类: "+context.getClass().getName());

        System.out.println("Environment 实现类: " + context.getEnvironment().getClass().getName());

        EventConfiguration eventConfiguration = context.getBean(EventConfiguration.class);

        System.out.println(JSON.toJSONString(eventConfiguration));

        //关闭上下文
        context.close();
    }
}
