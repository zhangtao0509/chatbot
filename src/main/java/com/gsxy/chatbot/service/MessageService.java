package com.gsxy.chatbot.service;

import com.gsxy.chatbot.model.Message;

import java.util.List;

public interface MessageService {

    int saveMessages(List<Message> messageList);

    List<Message> findMessageList(int id);
}
