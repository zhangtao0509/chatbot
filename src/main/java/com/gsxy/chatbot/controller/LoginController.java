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

    /**
     * 跳转登陆页面
     *
     * @return
     */
    @RequestMapping(value = {"/index", "/","login"})
    public String getLoginView() {
        return "login";
    }

    /**
     * 跳转注册页面
     *
     * @return
     */
    @RequestMapping(value = "/registerPage")
    public String getRegisterView() {
        return "register";
    }

    /**
     * 登陆接口
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(String account, String password) {
        LoginResponse loginResponse = new LoginResponse();
        //查数据库校验用户密码对不对，不对可以调到登录页面，提示用户名密码错误或者不存在
        Boolean verifyLogin = userService.verifyLogin(account, password);
        if (verifyLogin == false) {
            loginResponse.setSuccess(false);
            loginResponse.setMsg("登录失败");
            return loginResponse;
        }
        loginResponse.setSuccess(true);
        loginResponse.setMsg(account);
        loginResponse.setUrl("/chat");
        return loginResponse;
    }

    /**
     * 注册接口
     *
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse register(String account, String password) {
        LoginResponse loginResponse = new LoginResponse();
        String register = userService.register(new User(account, password));
        if (register.equals("success")) {
            loginResponse.setSuccess(true);
            loginResponse.setMsg("注册成功");
            loginResponse.setUrl("/login");
            return loginResponse;
        }
        loginResponse.setSuccess(false);
        loginResponse.setUrl("/register");
        loginResponse.setMsg(register);
        return loginResponse;
    }
}