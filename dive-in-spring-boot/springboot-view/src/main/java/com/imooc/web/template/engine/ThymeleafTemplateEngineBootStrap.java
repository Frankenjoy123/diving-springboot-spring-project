package com.imooc.web.template.engine;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Thymeleaf 模块引擎引导类
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/10.
 */
//@SpringBootApplication
public class ThymeleafTemplateEngineBootStrap {

    public static void main(String[] args) throws IOException {

        // 构建引擎
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        // 创建渲染上下文
        Context context = new Context();
        context.setVariable("message", "Hello,World");

        //读取路径从 classpath:/templates/thymeleaf/helloworld.html
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource =
                resourceLoader.getResource("classpath:/templates/thymeleaf/helloworld.html");

        File file = resource.getFile();
        FileInputStream fileInputStream = new FileInputStream(file);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        IOUtils.copy(fileInputStream , outputStream);

        String content = outputStream.toString("utf-8");

        fileInputStream.close();
        outputStream.close();

//        // 模板的内容
//        String content = "<p th:text=\"${message}\">!!!</p>";

//        // 渲染（处理）结果
        String result = templateEngine.process(content, context);

        // 输出渲染（处理）结果
        System.out.println(result);

    }
}
