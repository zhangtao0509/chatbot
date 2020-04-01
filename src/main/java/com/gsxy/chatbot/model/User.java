package com.gsxy.chatbot.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户类
 */
@Data
public class User extends BaseModel implements Serializable {
    /**
     * id
     */
    private int id;

    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private int gender;
    /**
     * 头像
     */
    private String head_image;
}
