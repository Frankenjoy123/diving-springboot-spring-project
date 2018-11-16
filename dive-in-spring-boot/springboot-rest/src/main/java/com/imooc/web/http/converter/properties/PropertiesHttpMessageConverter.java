package com.imooc.web.http.converter.properties;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * {@link Properties} {@link HttpMessageConverter} 实现
 * 参考实现 {@link org.springframework.http.converter.json.MappingJackson2HttpMessageConverter}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/16.
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    public PropertiesHttpMessageConverter() {
        //设置支持的MediaType
        super(new MediaType("text","properties"));
    }

    @Override
    protected void writeInternal(Properties properties, @Nullable Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //获取字符编码
        Charset charset = outputMessage.getHeaders().getContentType().getCharset();
        charset = charset == null ? Charset.forName("utf-8") : charset;

        //获取字符流
        OutputStream outputStream = outputMessage.getBody();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream , charset);
        properties.store(writer,"from PropertiesHttpMessageConverter");
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {

        //从请求头 content-type 获取编码
        HttpHeaders headers =  inputMessage.getHeaders();
        MediaType mediaType = headers.getContentType();
        Charset charset = mediaType.getCharset();
        //当charset不存在时，使用utf-8
        charset = charset == null ? Charset.forName("utf-8") : charset;

        //字节流
        InputStream inputStream = inputMessage.getBody();


        //字符流
        InputStreamReader reader = new InputStreamReader(inputStream ,charset);
        Properties properties = new Properties();
        //加载字符流
        properties.load(reader);
        return properties;
    }

    @Override
    public Properties read(Type type, @Nullable Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null , inputMessage);
    }
}
