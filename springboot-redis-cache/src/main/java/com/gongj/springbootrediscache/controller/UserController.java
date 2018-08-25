package com.gongj.springbootrediscache.controller;

import com.gongj.springbootrediscache.domain.User;
import com.gongj.springbootrediscache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public void saveUser(User user){
        userService.save(user);
    }

    @RequestMapping("/getUser")
    public User getUser(Integer uid){
        return userService.getUser(uid);
    }

}
