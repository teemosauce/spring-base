package com.yp.springbase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yp.springbase.entity.Log;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogMapper extends BaseMapper<Log> {
}
