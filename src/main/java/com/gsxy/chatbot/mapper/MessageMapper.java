package com.gsxy.chatbot.mapper;

import com.gsxy.chatbot.model.Message;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    int saveMessages(@Param("messageList") List<Message> messageList);
}
