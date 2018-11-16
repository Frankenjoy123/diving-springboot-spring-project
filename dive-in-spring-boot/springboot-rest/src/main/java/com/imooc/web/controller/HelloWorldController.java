package com.imooc.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld {@link RestController}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/13.
 */
@RestController
public class HelloWorldController {

    @GetMapping("hello")
    public String hello(@RequestParam(required = false) String message){
        return "hello,world ：  "  + message;
    }

}
