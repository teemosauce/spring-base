package com.yp.springbase;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
//@MapperScan(basePackages = "com.yp.springbase.mapper")
public class SpringBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBaseApplication.class, args);

        log.error("启动啦");
    }

}
