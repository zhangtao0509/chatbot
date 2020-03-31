package com.gsxy.chatbot.service;

import com.gsxy.chatbot.model.User;

public interface UserService {
    /**
     * 获取用户信息通过id
     * @param id
     * @return
     */
    User getUserById(int id);
}
