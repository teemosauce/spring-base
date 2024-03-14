package com.yp.springbase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yp.springbase.entity.Order;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
