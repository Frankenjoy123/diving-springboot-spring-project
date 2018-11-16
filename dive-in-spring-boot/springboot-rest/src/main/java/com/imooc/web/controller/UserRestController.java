package com.imooc.web.controller;

import com.imooc.web.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User {@link RestController}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/15.
 */
@RestController
public class UserRestController {

    @PostMapping(value = "/echo/user" ,
            consumes = "application/json;charset=utf-8", //对请求头，content-type过滤
            produces = "application/json;charset=gbk") //设置响应头，content-type过滤
                                                        //如果和请求头Accept不一致会报415 MediaType不一致
    public User getUser(@RequestBody User user){
        return user;
    }
}
