package com.imooc.web.method.support;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link java.util.Properties} {@link HandlerMethodArgumentResolver} 实现
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/18.
 */
public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver{

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Properties.class);
    }

    @Nullable
    @Override
    public Object resolveArgument(MethodParameter parameter, @Nullable ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) throws Exception {
        //字节流
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        HttpServletRequest httpServletRequest =  servletWebRequest.getRequest();

//        String contentType = httpServletRequest.getHeader("content-type");
//        MediaType mediaType = MediaType.parseMediaType(contentType);
//        Charset charset =mediaType.getCharset();
//        //当charset不存在时，使用utf-8
//        charset = charset == null ? Charset.forName("utf-8") : charset;
//        InputStream inputStream = httpServletRequest.getInputStream();
//
//        //字符流
//        InputStreamReader reader = new InputStreamReader(inputStream ,charset);
//        Properties properties = new Properties();
//        //加载字符流
//        properties.load(reader);

        //委托PropertiesHttpMessageConverter，进行读取参数
        HttpInputMessage inputMessage = new ServletServerHttpRequest(httpServletRequest);
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        return converter.read(null,null,inputMessage);
    }
}
