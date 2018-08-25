package com.gongj.springbootjpa.controller;

import com.gongj.springbootjpa.domain.User;
import com.gongj.springbootjpa.service.UserService;
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

}
