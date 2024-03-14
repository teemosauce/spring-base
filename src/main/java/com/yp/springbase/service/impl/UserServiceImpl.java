package com.yp.springbase.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.springbase.base.framework.BaseQueryDTO;
import com.yp.springbase.base.framework.PageRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.Log;
import com.yp.springbase.mapper.LogMapper;
import com.yp.springbase.mapper.UserMapper;
import com.yp.springbase.entity.User;
import com.yp.springbase.service.LogService;
import com.yp.springbase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private LogService logService;

    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional
    public int create(User user) {
       int row  = this.getBaseMapper().insert(user);
        Log log = new Log() {{
            setMessage("插入了一条数据" + JSON.toJSONString(user));
            setCreateTime(new Date());
            setId(1284526082);
        }};
        this.logMapper.insert(log);
        return row;
    }


    @Transactional
    @Override
    public int update(User user) throws InterruptedException {
       int row = getBaseMapper().updateById(user);
       return row;
    }


    @Override
    public PageRespDTO<List<UserRespDTO>> list(UserQueryDTO userQueryDTO) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.hasLength(userQueryDTO.getName()), User::getName, userQueryDTO.getName());

        IPage<User> page = BaseQueryDTO.page(userQueryDTO);

        log.info(String.valueOf(page.getSize()));
        log.info(String.valueOf(page.getCurrent()));

        Page<User> page2 = new Page<>(userQueryDTO.getPageNumber(), userQueryDTO.getPageSize());
        IPage<User> users = this.getBaseMapper().selectPage(page2, queryWrapper);

        log.info(String.valueOf(users.getCurrent()));
        log.info(String.valueOf(users.getTotal()));
        log.info(String.valueOf(users.getPages()));

        List<UserRespDTO> userRespList =  users.getRecords().stream().map(u -> new UserRespDTO(){{
            setId(u.getId());
            setName(u.getName());
            setCreateTime(u.getCreateTime());
            setUpdateTime(u.getUpdateTime());
        }}).collect(Collectors.toList());

        return PageRespDTO.make(userRespList, users);
    }
}
