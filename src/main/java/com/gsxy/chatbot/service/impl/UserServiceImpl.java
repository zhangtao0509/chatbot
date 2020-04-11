package com.gsxy.chatbot.service.impl;

import com.gsxy.chatbot.mapper.UserMapper;
import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Mapper
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserNameByName(User user) {
        return null;
    }

    @Override
    public Boolean verifyLogin(String userName, String password) {
        return userMapper.verifyLogin(userName, password) > 0 ? true : false;
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Override
    public User register(User user) {
        User result = new User();
        result.setSuccess(false);

        User existUser = userMapper.findUserNameByName(result.getName());
        try {
            if (existUser != null) {
                result.setMsg("用户名已存在！");
            } else {
                userMapper.regist(user);
                result.setMsg("注册成功");
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg(e.getMessage());
        }
        return result;
    }

    @Override
    public User login(User user) {
        User result = new User();
        result.setSuccess(false);
        Long userId = userMapper.login(user);
        try {
            if (userId == null) {
                result.setMsg("用户名或密码不正确");
            } else {
                result.setMsg("登录成功！");
                result.setSuccess(true);
            }
        } catch (Exception e) {
            e.getStackTrace();
            result.setMsg(e.getMessage());

        }

        return result;
    }


}
