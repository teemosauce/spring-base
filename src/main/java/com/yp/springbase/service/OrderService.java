package com.yp.springbase.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Async
    public void async() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("我是一个异步的任务" + Thread.currentThread().getName());
    }

    public void sync() {
        System.out.println("我是同步任务" + Thread.currentThread().getName());
    }

}
