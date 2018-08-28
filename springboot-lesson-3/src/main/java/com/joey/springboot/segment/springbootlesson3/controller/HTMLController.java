package com.joey.springboot.segment.springbootlesson3.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/8/28.
 */
@RestController
public class HTMLController {

//    @RequestMapping(path = {"/html/demo","html/demo2"}
//        ,method = {RequestMethod.GET,RequestMethod.POST})
//    @ResponseBody
    @GetMapping(path = "/html/demo")
    public String html(){
        return "<html><body>hello , world</body></html>";
    }


    @GetMapping("/html/demo/header")
    public String head(@RequestHeader(value = "Accept") String auth){
        return "<html><body>Request 'Accept' header value : " + auth + " </body></html>";
    }

    @GetMapping("/html/demo/response/entity")
    public ResponseEntity<String> responseEntity(){


        HttpHeaders headers = new HttpHeaders();
        headers.put("myKey", Arrays.asList("hello"));
        ResponseEntity<String> entity = new ResponseEntity<String>("hello,world",headers,
                HttpStatus.OK);

        return entity;
    }


    @GetMapping("ok.htm")
    public String ok(){

        return "ok";
    }
}
