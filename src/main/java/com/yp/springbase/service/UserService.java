package com.yp.springbase.service;

import com.yp.springbase.dto.BaseRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.User;

import java.util.List;

public interface UserService {
    int create(User user);


    BaseRespDTO<List<UserRespDTO>> list(UserQueryDTO userQueryDTO);
}
