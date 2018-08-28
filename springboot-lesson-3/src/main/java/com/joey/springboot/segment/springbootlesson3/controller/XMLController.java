package com.joey.springboot.segment.springbootlesson3.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/8/28.
 */
@Controller
public class XMLController {
    /**
     * 这里会存在这个报错
     * There was an unexpected error (type=Not Acceptable, status=406).
     Could not find acceptable representation
     * @return
     */
    @RequestMapping(path = "/xml/user",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User user() {

        User user = new User();

        user.setName("XML");
        user.setAge(30);

        return user;
    }
}
