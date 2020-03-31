package com.gsxy.chatbot.service.impl;

import com.gsxy.chatbot.mapper.UserMapper;
import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
