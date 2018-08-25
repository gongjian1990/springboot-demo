package com.gongj.springbootrediscache.service;


import com.gongj.springbootrediscache.domain.User;

public interface UserService {

    void save(User user);

    User getUser(Integer uid);
}
