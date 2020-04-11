package com.gsxy.chatbot.model;

import lombok.Data;

@Data
public class LoginResponse {
    private String url;
    private String msg;
    private Boolean success;
}
