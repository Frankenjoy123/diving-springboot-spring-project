package com.imooc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Hello World {@link org.springframework.stereotype.Controller}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/10.
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/helloworld")
    public String hellowolrd(){
        return "helloworld"; //view 逻辑名称
    }


    @RequestMapping("")
    public String index(@RequestParam(required = false , defaultValue = "0") int value , Model model) {
//        model.addAttribute("message","hello , world");

//        model.addAttribute("acceptLanguage",acceptLanguage);
//        model.addAttribute("jsessionid",jsessionid);

        return "index";
    }


}
