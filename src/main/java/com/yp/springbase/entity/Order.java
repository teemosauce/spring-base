package com.yp.springbase.entity;

import java.util.Date;

public class Order extends BaseEntity {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
