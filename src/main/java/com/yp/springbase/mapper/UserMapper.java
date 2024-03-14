package com.yp.springbase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yp.springbase.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
