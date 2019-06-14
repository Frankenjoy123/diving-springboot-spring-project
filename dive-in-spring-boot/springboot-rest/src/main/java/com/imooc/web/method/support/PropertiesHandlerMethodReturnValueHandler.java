package com.imooc.web.method.support;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties} {@link HandlerMethodReturnValueHandler} 实现
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/18.
 */
public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        //判断方法返回类型是否Properties
        return returnType.getMethod().getReturnType().equals(Properties.class);
    }

    @Override
    public void handleReturnValue(@Nullable Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;

        //Servlet Request API
        HttpServletRequest httpServletRequest =  servletWebRequest.getRequest();
        String contentType = httpServletRequest.getHeader("content-type");
        MediaType mediaType = MediaType.parseMediaType(contentType);

        //构造HttpOutputMessage
        HttpServletResponse httpServletResponse = servletWebRequest.getResponse();
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(httpServletResponse);

        //强制转换
        Properties properties = (Properties) returnValue;
        //借助输出 PropertiesHttpMessageConverter
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        converter.write(properties,mediaType , outputMessage);

        // 参考RequestResponseBodyMethodProcessor.handleReturnValue()
        // 告诉mvc请求已处理完成
        mavContainer.setRequestHandled(true);
    }
}
