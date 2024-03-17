package com.yp.springbase.base.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

@ConditionalOnClass(String.class)
public class TestBean {
    public void test() {
        System.out.println("test");
    }
}
