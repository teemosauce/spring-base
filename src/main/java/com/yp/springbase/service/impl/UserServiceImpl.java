package com.yp.springbase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.springbase.base.framework.BaseQueryDTO;
import com.yp.springbase.base.framework.PageRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.mapper.UserMapper;
import com.yp.springbase.entity.User;
import com.yp.springbase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int create(User user) {
        return this.getBaseMapper().insert(user);
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
        }}).collect(Collectors.toList());

        return PageRespDTO.make(userRespList, users);
    }
}
