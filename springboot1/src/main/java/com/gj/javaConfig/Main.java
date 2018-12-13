package com.gj.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    /**
     * 测试 使用java 方式配置
     * @param args
     */
    public static void main(String[] args) {

        // 通过Java配置来实例化Spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = (UserService)context.getBean("userService");

        User user = userService.getUser();

        System.out.println(user.getName());

        Datasource datasource = (Datasource)context.getBean("datasource");

        System.out.println(datasource.getUrl());

    }

}
