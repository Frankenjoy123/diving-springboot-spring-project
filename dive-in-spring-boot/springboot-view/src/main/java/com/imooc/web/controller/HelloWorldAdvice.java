package com.imooc.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * {@link HelloWorldController} 切面通知
 * Created by xiaowu.zhou on 2018/11/10.
 */
@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldAdvice {

    @ModelAttribute("message")
    public String getMessage(){
        return "hello , world";
    }

    @ModelAttribute("acceptLanguage")
    public String acceptLanguage(@RequestHeader("Accept-Language") String acceptLanguage){
        return acceptLanguage;
    }

    @ModelAttribute("jsessionid")
    public String jsessionid(@CookieValue(value = "JSESSIONID" , required = false) String jsessionid){
        return jsessionid;
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable){
        return ResponseEntity.ok(throwable.getMessage());
    }

}
