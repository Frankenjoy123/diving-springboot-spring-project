package com.joey.annotationspringbootdemo.repository;

import com.joey.annotationspringbootdemo.annotation.FirstLevelRepository;
import com.joey.annotationspringbootdemo.annotation.SecondLevelRepository;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/1.
 */
@SecondLevelRepository("mySecondRepository")
public class MySecondRepository {


}
