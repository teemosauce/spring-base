package com.yp.springbase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.springbase.entity.Log;
import com.yp.springbase.mapper.LogMapper;
import com.yp.springbase.service.LogService;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
