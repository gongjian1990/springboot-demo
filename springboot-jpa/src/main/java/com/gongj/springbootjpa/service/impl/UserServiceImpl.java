package com.gongj.springbootjpa.service.impl;

import com.gongj.springbootjpa.domain.User;
import com.gongj.springbootjpa.repository.UserRepository;
import com.gongj.springbootjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
