package com.joey.segmentment.lessson20starter.controller;

import com.joey.segmentment.starter.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/9/13.
 */
@RestController
public class TestController {


    @Autowired
    private Person person;

    @GetMapping(value = "/person")
    public Person get(){
        return person;
    }

}
