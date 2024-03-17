package com.yp.springbase;

import com.yp.springbase.base.config.TestBean;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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


    private class A {

        @Resource
        private TestBean testBean;

        public void hello() {
            testBean.test();
        }

    }

}
