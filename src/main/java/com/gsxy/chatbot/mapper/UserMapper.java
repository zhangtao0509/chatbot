package com.gsxy.chatbot.mapper;

import com.gsxy.chatbot.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    int verifyLogin(@Param("account") String account, @Param("pwd") String password);//验证用户密码

    User findUserNameByAccount(String account);//比较是否有相同用户名

    void register(User user);//注册用户
}


