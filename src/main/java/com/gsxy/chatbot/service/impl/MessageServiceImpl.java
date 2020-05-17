package com.gsxy.chatbot.service.impl;

import com.gsxy.chatbot.mapper.MessageMapper;
import com.gsxy.chatbot.model.Message;
import com.gsxy.chatbot.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int saveMessages(List<Message> messageList) {
        return messageMapper.saveMessages(messageList);
    }
}
