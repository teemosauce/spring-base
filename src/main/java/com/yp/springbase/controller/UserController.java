package com.yp.springbase.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yp.springbase.dto.BaseRespDTO;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.User;
import com.yp.springbase.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public int create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/list")
    public BaseRespDTO<List<UserRespDTO>> list(@RequestBody UserQueryDTO userQueryDTO) {
        log.info("哈哈哈哈哈");
        return userService.list(userQueryDTO);
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }

}
