package com.imooc.spring.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

/**
 * hello world {@link Controller} 实现
 * Created by xiaowu.zhou@tongdun.cn on 2018/11/19.
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<DeferredResult<String>>(5);

    private final Random random = new Random();

    @Scheduled(fixedRate = 5000L)
    public void process() throws InterruptedException {
        DeferredResult<String> result = null;

        do {
            result = queue.take();
            //随机超时时间
            long timeout = random.nextInt(100);
            //模拟等待时间 RPC 或者DB查询
            Thread.sleep(timeout);
            result.setResult("hello world");
            printf("执行计算结果，消耗"+timeout+"ms");


        }while (result != null);

    }

    @RequestMapping("hello")
    public DeferredResult<String> hello(){
        DeferredResult<String> result = new DeferredResult<>(50L);
//        result.setResult("hello world");

        //入队操作
        queue.offer(result);

        printf("hello world");
        result.onCompletion(() -> {
            printf("执行完成");
        });

        result.onTimeout(() -> {
            printf("执行超时");
        });

        return result;
    }


    @RequestMapping("/callable/hello")
    public Callable<String> callableHello(){
        final long startTime = System.currentTimeMillis();
        printf("hello world ...");


        return () -> {
            long costTime = System.currentTimeMillis() - startTime;

            printf("执行计算结果，消耗"+costTime+"ms");
            return "hello world";
        };

    }

    private void printf(Object obj){
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController["+threadName+"] " + obj);
    }
}
