package com.yp.springbase.entity;

import com.yp.springbase.base.framework.BaseEntity;

public class Order extends BaseEntity {

    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
