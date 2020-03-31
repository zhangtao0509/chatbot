package com.gsxy.chatbot.mapper;

import com.gsxy.chatbot.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    /**
     * 获取用户信息通过id
     *
     * @param id
     * @return
     */
    User getUserById(int id);
}
