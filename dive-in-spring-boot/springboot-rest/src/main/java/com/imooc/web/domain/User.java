package com.imooc.web.domain;

/**
 * 用户模型
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/15.
 */
public class User {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
