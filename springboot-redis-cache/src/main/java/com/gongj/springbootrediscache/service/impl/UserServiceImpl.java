package com.gongj.springbootrediscache.service.impl;

import com.gongj.springbootrediscache.domain.User;
import com.gongj.springbootrediscache.repository.UserRepository;
import com.gongj.springbootrediscache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Cacheable(value = "user",key = "#uid")
    public User getUser(Integer uid) {
        return userRepository.findOne(uid);
    }
}
