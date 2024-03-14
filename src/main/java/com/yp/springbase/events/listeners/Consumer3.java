package com.yp.springbase.events.listeners;

import com.yp.springbase.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Consumer3 {


    @EventListener
    @Async
    protected void call(PaySuccessEvent event) {
        User user = (User) event.getSource();

        System.out.println(Thread.currentThread());
        System.out.println("3 收到数据" + user);
    }
}
