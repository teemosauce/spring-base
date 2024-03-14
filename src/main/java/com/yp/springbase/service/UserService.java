package com.yp.springbase.service;

import com.yp.springbase.base.framework.PageRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.User;

import java.util.List;

public interface UserService {
    int create(User user);

    int update(User user) throws InterruptedException;

    PageRespDTO<List<UserRespDTO>> list(UserQueryDTO userQueryDTO);
}
