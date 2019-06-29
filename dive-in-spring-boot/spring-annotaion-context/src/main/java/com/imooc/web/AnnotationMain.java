package com.imooc.web;

import com.imooc.web.beans.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xiaowu.zhou on 2019/6/29.
 */
public class AnnotationMain {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("com.imooc.web");

        Person person = (Person) context.getBean("person");
        System.out.println(person.getName());

//        context.re
//        context.set


    }
}
