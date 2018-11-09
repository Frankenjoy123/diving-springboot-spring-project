package com.imooc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hello world {@link org.springframework.stereotype.Controller}
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/7.
 */

@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index() {
        return "index";
    }
}