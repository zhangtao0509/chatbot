package com.gsxy.chatbot.controller;


import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import com.sun.xml.internal.fastinfoset.util.PrefixArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getLoginView(HttpServletRequest request) {
//        if (request.getSession().getAttribute("admin") != null)
//            return "index";
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean login(String username, String password, Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查数据库校验用户密码对不对，不对可以调到登录页面，提示用户名密码错误或者不存在
        User user = new User();
        user.setName(username);
        user.setPwd(password);
        User verifyLogin = userService.VerifyLogin(user);
//        if (verifyLogin==null){
        if (false){
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            model.addAttribute("error", "登录失败");
            return false;

//            return "login";
        }
        //是对的话，跳到聊天界面
        request.getRequestDispatcher("/hello.html").forward(request,response);
        return true;
    }



}