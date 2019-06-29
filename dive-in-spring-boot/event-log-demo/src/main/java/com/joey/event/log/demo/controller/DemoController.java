package com.joey.event.log.demo.controller;

import com.joey.analyze.event.log.client.annotation.EventAction;
import com.joey.analyze.event.log.client.annotation.EventParam;
import com.joey.analyze.event.log.client.annotation.EventPath;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaowu.zhou on 2019/6/20.
 */
@RestController
@RequestMapping("/demo")
@EventPath({"测试","路径"})
public class DemoController {

    @EventAction("查询")
    @RequestMapping("/test")
    public String getTest(@EventParam("name") @RequestParam String name){
        return "hello : " + name;
    }

    @RequestMapping("/test2")
    public String getTest2(@RequestParam String name){
        return "hello : " + name;
    }


}
