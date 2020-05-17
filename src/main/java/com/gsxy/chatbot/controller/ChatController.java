package com.gsxy.chatbot.controller;

import com.gsxy.chatbot.model.LoginResponse;
import com.gsxy.chatbot.model.Message;
import com.gsxy.chatbot.model.User;
import com.gsxy.chatbot.service.MessageService;
import com.gsxy.chatbot.service.UserService;
import com.gsxy.chatbot.thirdApi.TuLingApi;
import com.gsxy.chatbot.thirdApi.bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private UserService userService;

    @Autowired
    private TuLingApi tuLingApi;

    @Autowired
    private MessageService messageService;

    /**
     * 跳转聊天界面
     *
     * @param account
     * @param model
     * @return
     */
    @RequestMapping(value = "/chat")
    public String chat(@RequestParam("account") String account, ModelMap model) {
        User user = userService.getUser(account);
        List<Message> messageList = messageService.findMessageList(user.getId());
        if (!CollectionUtils.isEmpty(messageList)){
            model.addAttribute("messageList", messageList);
        }
        model.addAttribute("account", account);
        return "chat";
    }

    /**
     * 发送聊天内容
     *
     * @param account
     * @param message
     * @return
     */
    @RequestMapping(value = "/send")
    @ResponseBody
    public LoginResponse send(@RequestParam("account") String account, @RequestParam("message") String message) {
        LoginResponse loginResponse = new LoginResponse();
        String msg = "";
        User user = userService.getUser(account);
        if (user != null) {
            List<Result> results = tuLingApi.sendMessage(message, String.valueOf(user.getId()));
            if (!CollectionUtils.isEmpty(results)) {
                msg = results.get(0).getValues().getText();
            }
        }
        //保存聊天内容
        if (!StringUtils.isEmpty(msg)) {
            List<Message> messages = Arrays.asList(new Message(user.getId(), 1, message, 0), new Message(user.getId(), 1, msg, 1));
            messageService.saveMessages(messages);
            loginResponse.setSuccess(true);
            loginResponse.setMsg(msg);
        }else {
            loginResponse.setSuccess(false);
        }
        return loginResponse;
    }
}