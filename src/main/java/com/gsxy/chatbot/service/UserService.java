package com.gsxy.chatbot.service;

import com.gsxy.chatbot.model.User;

public interface UserService {

    User register(User user);

    User login(User user);

    User findUserNameByName(User user);

    User  VerifyLogin(User user);
}
