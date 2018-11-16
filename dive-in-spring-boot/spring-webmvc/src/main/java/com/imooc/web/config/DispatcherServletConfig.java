package com.imooc.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * {@link DispatcherServlet} 配置类
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/10.
 */
@Configuration
@ComponentScan(basePackages = "com.imooc.web")
public class DispatcherServletConfig {

}
