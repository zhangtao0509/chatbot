package com.gsxy.chatbot.service.impl;

import com.gsxy.chatbot.mapper.UserMapper;
import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Mapper
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean verifyLogin(String account, String password) {
        return userMapper.verifyLogin(account, password) > 0 ? true : false;
    }

    @Override
    public User getUser(String account) {
        return userMapper.findUserNameByAccount(account);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public String register(User user) {
        User existUser = userMapper.findUserNameByAccount(user.getAccount());
        try {
            if (existUser != null) {
                return "用户名已存在";
            } else {
                userMapper.register(user);
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "服务内部错误，请联系开发人员";
        }
    }

}
