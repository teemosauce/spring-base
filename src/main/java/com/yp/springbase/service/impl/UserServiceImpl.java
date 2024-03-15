package com.yp.springbase.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private ServerProperties properties;

    @Autowired
    private RestTemplate restTemplate;

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
//            setId(1284526082);
        }};
        this.logMapper.insert(log);
        return row;
    }


    @Transactional
    @Override
    public boolean update(User user) {

        // 有事务 并且数据修改成功
        boolean success = this.updateById(user);


        // 在本服务中查询刚修改的数据是可以查到的
        PageRespDTO<List<UserRespDTO>> userPageRespDTO =  this.list(new UserQueryDTO() {{
            setName(user.getName());
        }});
        log.info("本服务查询的数据：" + userPageRespDTO.getRecords().get(0));

        log.info("数据修改完整：" + success);
        if (properties.getPort() == 8081) {


            new Thread(() -> {
                log.info(Thread.currentThread().getName() + "开始运行");
                User updateUser = new User(){{
                    setId(user.getId());
                    setName(user.getName());
//                setId(-1501503486); // 修改别的用户
//                setName("汪小姐");

                }};

                // 去跨服务查 数据还是查不出来的 因为事务还未提交
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json");
                HttpEntity<String> requestEntity = new HttpEntity<>(JSON.toJSONString(updateUser), headers);
//            ResponseEntity<String> res = restTemplate.exchange("http://localhost:8080/user", HttpMethod.PUT, requestEntity, String.class);
                ResponseEntity<String> res = restTemplate.exchange("http://localhost:8080/user/updateById", HttpMethod.POST, requestEntity, String.class);

//            ResponseEntity<String> res = restTemplate.exchange("http://localhost:8080/user/list", HttpMethod.POST, requestEntity, String.class);

                log.info(res.getStatusCode().toString());
                log.info(res.getHeaders().toString());
                log.info("跨服务查询出来的数据：" + res.getBody());
            }).start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info("返回结果吗");
        }
       return success;
    }

    @Override
    public PageRespDTO<List<UserRespDTO>> list(UserQueryDTO userQueryDTO) {

        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper.eq(StringUtils.hasLength(userQueryDTO.getName()), User::getName, userQueryDTO.getName());

        IPage<User> page = BaseQueryDTO.page(userQueryDTO);

        log.info(String.valueOf(page.getSize()));
        log.info(String.valueOf(page.getCurrent()));

        IPage<User> users = this.getBaseMapper().selectPage(page, queryWrapper);

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
