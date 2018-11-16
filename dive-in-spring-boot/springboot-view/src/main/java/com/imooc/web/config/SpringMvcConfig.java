package com.imooc.web.config;

import org.apache.catalina.Context;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 *
 * Spring mvc java代码配置方式 （替换xml配置方式）
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/8.
 *
 * //@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)

 */
@Configuration
//@EnableWebMvc 这个生效，WebMvcAutoConfiguration就不会生效
//
public class SpringMvcConfig{


//    <!--<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">-->
//        <!--<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>-->
//        <!--<property name="prefix" value="/WEB-INF/jsp/"/>-->
//        <!--<property name="suffix" value=".jsp"/>-->
//    <!--</bean>-->

    @Bean
    public InternalResourceViewResolver defaultViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");

        // Thymeleaf resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 5);
        // 比ThymeleafViewResolver优先级高
        viewResolver.setOrder(Ordered.LOWEST_PRECEDENCE -10);

        viewResolver.setContentType("application/xml");
        return viewResolver;
    }


    /**
     * 1.bean的方式，直接注册{@link WebMvcConfigurer}
     * 2.也可直接实现{@link WebMvcConfigurer}接口
     */

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new HandlerInterceptor() {
                    @Override
                    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                        System.out.println("handler执行前");
                        return true;
                    }
                });
            }

            @Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                configurer.favorParameter(true)
                        .favorPathExtension(true);

            }
        };

        return configurer;
    }


    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customer(){

        return factory -> {
            factory.addContextCustomizers((TomcatContextCustomizer) context -> {
//                    相对于/dive-in-spring-boot
                String relativePath = "springboot-view/src/main/webapp";

                File file =new File(relativePath);
                if (file.exists()){
                    //解决maven 多模块时，嵌入式tomcat jsp定位问题
                    context.setDocBase(file.getAbsolutePath());
                }

            });
        };
    }

}
