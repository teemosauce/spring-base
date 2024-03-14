package com.yp.springbase.events.listeners;

import com.yp.springbase.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {


    @EventListener
    protected void call(PaySuccessEvent event) throws InterruptedException {
        User user = (User) event.getSource();
        Thread.sleep(5000);
        System.out.println(Thread.currentThread());
        System.out.println("1 收到数据" + user);
    }
}
