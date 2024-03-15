package com.yp.springbase.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yp.springbase.base.framework.PageRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.User;

import java.util.List;

public interface UserService extends IService<User> {
    int create(User user);

    boolean update(User user);

    PageRespDTO<List<UserRespDTO>> list(UserQueryDTO userQueryDTO);
}
