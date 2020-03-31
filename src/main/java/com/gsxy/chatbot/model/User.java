package com.gsxy.chatbot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 */
@Data
public class User implements Serializable {
    /**
     * id
     */
    private int id;

    /**
     * 姓名
     */
    private String name;
}
