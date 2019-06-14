package com.imooc.web.controller;

import com.imooc.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.imooc.web.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * {@link Properties} {@link RestController}
 * {@link PropertiesHandlerMethodArgumentResolver} 自定义处理方法参数
 * {@link PropertiesHandlerMethodReturnValueHandler} 自定义处理方法返回值
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/15.
 */
//@RestController
@Controller //使用自定义的PropertiesHandlerMethodReturnValueHandler实现
public class PropertiesCustomizerController {

    @PostMapping(value = "/add/pros/custom"
            , consumes = "text/properties;charset=utf-8") //过滤请求头 content-type媒体类型
    public Properties add(
//              @RequestBody 不依赖 RequestResponseBodyMethodProcessor
                Properties properties){
        return properties;
    }
}
