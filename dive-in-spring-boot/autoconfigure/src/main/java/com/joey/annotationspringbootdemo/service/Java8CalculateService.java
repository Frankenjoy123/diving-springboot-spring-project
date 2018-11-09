package com.joey.annotationspringbootdemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 * java8  lambda实现
 */
@Service
@Profile("java8")
public class Java8CalculateService implements CalculateService{

    @Override
    public Integer calculate(Integer... numbers) {

        System.out.println("java8  lambda实现");

        Integer sum = Stream.of(numbers).reduce(0,Integer::sum);
        return sum;
    }
}
