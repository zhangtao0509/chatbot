package com.gsxy.chatbot.controller;


import com.gsxy.chatbot.model.LoginResponse;
import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getLoginView() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(String username, String password, Model model) {
        LoginResponse loginResponse = new LoginResponse();
        //查数据库校验用户密码对不对，不对可以调到登录页面，提示用户名密码错误或者不存在
        Boolean verifyLogin = userService.verifyLogin(username,password);
        if (verifyLogin == false) {
            loginResponse.setSuccess(false);
            loginResponse.setMsg("登录失败");
            return loginResponse;
        }
        loginResponse.setSuccess(true);
        loginResponse.setUrl("/chat");
        return loginResponse;
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chat() {
        return "chat";
    }


}