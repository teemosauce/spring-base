package com.yp.springbase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.springbase.mapper.OrderMapper;
import com.yp.springbase.entity.Order;
import com.yp.springbase.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired

    private OrderMapper orderMapper;

    @Override
    public boolean create() {
        return false;
    }
}
