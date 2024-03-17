package com.yp.springbase.controller;

import com.yp.springbase.base.config.TestBean;
import com.yp.springbase.base.framework.PageRespDTO;
import com.yp.springbase.base.framework.ResponseResult;
import com.yp.springbase.dto.req.UserQueryDTO;
import com.yp.springbase.dto.res.UserRespDTO;
import com.yp.springbase.entity.User;
import com.yp.springbase.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
@Import(TestBean.class) // TestBean 本身没有注册到spring 容器中 通过这种方式进行注入
public class UserController {
    @Resource
    private TestBean testBean;

    @Autowired
    private UserService userService;

    @PostMapping
    public int create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping
    public Boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/updateById")
    public Boolean updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    @PostMapping("/list")
    public PageRespDTO<List<UserRespDTO>> list(@RequestBody UserQueryDTO userQueryDTO) {
        log.info("哈哈哈哈哈");
        return userService.list(userQueryDTO);
    }

    @GetMapping("/hi")
    public ResponseResult<String> hi() {
        testBean.test();
        return ResponseResult.success("你好");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
