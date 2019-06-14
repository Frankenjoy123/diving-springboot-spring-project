package com.imooc.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloWorld {@link RestController}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/13.
 */
@RestController
public class HelloWorldRestController {

//    @CrossOrigin("*")
    @GetMapping("/hello")
    public String hello(){
        return "hello,world ：";
    }

}
