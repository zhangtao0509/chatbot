package com.gsxy.chatbot.mapper;

import com.gsxy.chatbot.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    int verifyLogin(@Param("account") String userName, @Param("pwd") String password);//验证用户密码

    User findUserNameByName(String name);//比较是否有相同用户名

    void regist(User user);//注册用户

    Long login(User user);//登录
}


