package com.gsxy.chatbot.model;

import lombok.Data;

@Data
public class Message {
    //id
    private int id;

    private int userId;
    //消息类型：1.文本 2.图片 3.声音 4.视频 5.新闻
    private int messageType = 1;

    private String messageContent;
    //消息归属：0.用户 1.机器人
    private int isCustumer;

    public Message() {
    }

    public Message(int userId, int messageType, String messageContent, int isCustumer) {
        this.userId = userId;
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.isCustumer = isCustumer;
    }
}
