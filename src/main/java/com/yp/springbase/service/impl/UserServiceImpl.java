package com.yp.springbase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yp.springbase.dto.BaseQueryDTO;
import com.yp.springbase.dto.BaseRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.mapper.UserMapper;
import com.yp.springbase.entity.User;
import com.yp.springbase.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public int create(User user) {
        return this.getBaseMapper().insert(user);
    }

    @Override
    public BaseRespDTO<List<UserRespDTO>> list(UserQueryDTO userQueryDTO) {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.hasLength(userQueryDTO.getName()), User::getName, userQueryDTO.getName());

        IPage<User> page = BaseQueryDTO.page(userQueryDTO);

        IPage<User> users = this.getBaseMapper().selectPage(page, queryWrapper);

        List<UserRespDTO> userRespDTO =  users.getRecords().stream().map(u -> new UserRespDTO(){{
            setId(u.getId());
            setName(u.getName());
        }}).collect(Collectors.toList());

        return BaseRespDTO.make(Collections.singletonList(userRespDTO), users);
    }
}
