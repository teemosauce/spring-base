package com.yp.springbase.events.listeners;

import com.yp.springbase.entity.User;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {


    @EventListener
    protected void call(PaySuccessEvent event) throws InterruptedException {
        User user = (User) event.getSource();
        Thread.sleep(500);
        user.setName("娃哈哈");
        System.out.println(Thread.currentThread());
        System.out.println("2 收到数据" + user);
    }
}
