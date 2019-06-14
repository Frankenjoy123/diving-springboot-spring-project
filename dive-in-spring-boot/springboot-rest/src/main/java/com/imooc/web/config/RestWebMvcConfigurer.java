package com.imooc.web.config;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.imooc.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.imooc.web.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {@link WebMvcConfigurer} Rest实现
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/16.
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

//    @PostConstruct
    public void init(){
        List<HandlerMethodArgumentResolver> resolvers =
                requestMappingHandlerAdapter.getArgumentResolvers();

        List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>();
        //添加 PropertiesHandlerMethodArgumentResolver 到首位
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        //添加 已存在PropertiesHandlerMethodArgumentResolver
        newResolvers.addAll(resolvers);

        //重设置requestMappingHandlerAdapter
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);


        List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>();
        //添加 PropertiesHandlerMethodReturnValueHandler 到首位
        newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        //添加已注册 HandlerMethodReturnValueHandler
        newHandlers.addAll(handlers);

        //重设置requestMappingHandlerAdapter
        requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }

    /**
     * Add resolvers to support custom controller method argument types.
     * <p>This does not override the built-in support for resolving handler
     * method arguments. To customize the built-in support for argument
     * resolution, configure {@link RequestMappingHandlerAdapter} directly.
     * @param resolvers initially an empty list
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        //添加自定义HandlerMethodArgumentResolver，优先级低于内建build-in 添加自定义HandlerMethodArgumentResolver
//        resolvers.add(0,new PropertiesHandlerMethodArgumentResolver());

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到HttpMessageConverter list末尾
//        converters.add(new PropertiesHttpMessageConverter());
//        converters.add(0,new PropertiesHttpMessageConverter());
    }

}
