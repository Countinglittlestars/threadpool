package com.example.demo.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("myTaskAsyncPool")  //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    public void doTask1(int i) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"执行完毕");

    }

    @Async("myCountPool")  //myTaskAsynPool即配置线程池的方法名，此处如果不写自定义线程池的方法名，会使用默认的线程池
    public void doTask2(int i) throws InterruptedException{
        System.out.println(Thread.currentThread().getName()+"开始执行");
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName()+"执行完毕");

    }









}
