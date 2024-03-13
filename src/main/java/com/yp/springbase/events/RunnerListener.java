package com.yp.springbase.events;

import com.yp.springbase.events.listeners.PaySuccessEvent;
import com.yp.springbase.model.User;
import com.yp.springbase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class RunnerListener implements ApplicationRunner {

    @Autowired
    private OrderService orderService;

    @Autowired
    ApplicationContext applicationContext;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("应用程序启动成功");

//        this.sayWorld();
//        this.sayHello();

        ApplicationEvent event = new PaySuccessEvent(new User() {{
            setId(1);
            setName("小汪");
        }});
        applicationContext.publishEvent(event);
    }


    public void sayHello() {
        System.out.println("Hello" + Thread.currentThread().getName());
    }

    @Async
    public void sayWorld() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("World" + Thread.currentThread().getName());

        orderService.async();

        orderService.sync();
    }
}
