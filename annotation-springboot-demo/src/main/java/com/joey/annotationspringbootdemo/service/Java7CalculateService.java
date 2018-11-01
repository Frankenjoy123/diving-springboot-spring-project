package com.joey.annotationspringbootdemo.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 * java7 for 循环实现
 */
@Service("java7CalculateService")
@Profile("java7")
public class Java7CalculateService implements CalculateService{

    @Override
    public Integer calculate(Integer... numbers) {
        System.out.println("java7 for 循环实现");
        int sum =0;
        for (int i=0; i<numbers.length;i++){
            sum = numbers[i] +sum;
        }

        return sum;
    }


    public static void main(String[] args) {
        CalculateService service = new Java7CalculateService();
        System.out.println(service.calculate(1,2,3,4));
    }
}
