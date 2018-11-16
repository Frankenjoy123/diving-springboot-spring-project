package com.imooc.web.config;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * {@link WebMvcConfigurer} Rest实现
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/16.
 */
@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //不建议添加到HttpMessageConverter list末尾
//        converters.add(new PropertiesHttpMessageConverter());
        converters.add(0,new PropertiesHttpMessageConverter());
    }

}
