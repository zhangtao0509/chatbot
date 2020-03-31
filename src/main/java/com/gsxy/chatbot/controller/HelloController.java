package com.gsxy.chatbot.controller;

import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    private String hello(){
        return "hello";
    }

    @RequestMapping(value = "/getUser")
    @ResponseBody
    private User getUser(int id){
        return userService.getUserById(id);
    }

    @RequestMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }
}
