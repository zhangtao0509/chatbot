package com.gsxy.chatbot.service;

import com.gsxy.chatbot.model.User;

public interface UserService {

    String register(User user);

    Boolean  verifyLogin(String account,String password);

    User getUser(String account);
}
