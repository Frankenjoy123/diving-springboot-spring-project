package com.imooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * hello world {@link Controller}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/7.
 */

@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index(@RequestParam int value , Model model) {
//        model.addAttribute("message","hello , world");

//        model.addAttribute("acceptLanguage",acceptLanguage);
//        model.addAttribute("jsessionid",jsessionid);

        return "index";
    }


//    @ModelAttribute("message")
//    public String getMessage(){
//        return "hello , world";
//    }
//
//    @ModelAttribute("acceptLanguage")
//    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
//        return acceptLanguage;
//    }
//
//    @ModelAttribute("jsessionid")
//    public String jsessionid(@CookieValue("JSESSIONID") String jsessionid){
//        return jsessionid;
//    }


}