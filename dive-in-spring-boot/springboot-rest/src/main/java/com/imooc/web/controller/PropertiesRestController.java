package com.imooc.web.controller;

import com.imooc.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * {@link Properties} {@link RestController}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/15.
 */
@RestController
public class PropertiesRestController {

    @PostMapping(value = "/add/pros"
            , consumes = "text/properties;charset=utf-8") //过滤请求头 content-type媒体类型
    public Properties add(@RequestBody Properties properties){
        return properties;
    }
}
