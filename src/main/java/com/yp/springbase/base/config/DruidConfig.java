package com.yp.springbase.base.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    @Bean
    public DataSource masterDataSource() {
//        DruidDataSource druidDataSource = DruidDataSourceBuilder.create().build();
//        return druidDataSource;
   return null;
    }


}
