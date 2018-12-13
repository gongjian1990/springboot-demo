package com.gj.javaConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.gj")

// 读取properties 文件
@PropertySource("classpath:jdbc.properties")
public class SpringConfig {

    // java方式注入bean
    @Bean
    public UserDao userDao(){
        return new UserDao();
    }

    // 读取properties 的值文件
    @Value("${jdbc.url}")
    private String jdbcUrl;


    @Bean
    public Datasource datasource(){
        Datasource datasource = new Datasource();
        datasource.setUrl(jdbcUrl);
        return datasource;
    }


}
