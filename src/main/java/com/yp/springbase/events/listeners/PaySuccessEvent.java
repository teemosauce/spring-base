package com.yp.springbase.events.listeners;

import com.yp.springbase.model.User;
import org.springframework.context.ApplicationEvent;

public class PaySuccessEvent extends ApplicationEvent {

    public PaySuccessEvent(User user) {
        super(user);
    }

}
