package com.gsxy.chatbot.controller;

import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.UserService;
import com.gsxy.chatbot.thirdApi.TuLingApi;
import com.gsxy.chatbot.thirdApi.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    private TuLingApi tuLingApi;

    @RequestMapping(value = "/hello")
    @ResponseBody
    private String hello(){
        return "hello";
    }

    @RequestMapping("/thymeleaf")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name) {
        request.setAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    public List<Result> sendMessage(String message) throws IOException {
        return tuLingApi.sendMessage("牙疼怎么办?","0");
    }
}
