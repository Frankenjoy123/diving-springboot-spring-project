package com.imooc.web.beans;

import org.springframework.stereotype.Component;

/**
 * Created by xiaowu.zhou on 2019/6/29.
 */
@Component
public class Person {
    private String name = "xiaoming";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
