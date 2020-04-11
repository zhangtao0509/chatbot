package com.gsxy.chatbot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel implements Serializable {
    //id
    private int id;
    //姓名
    private String name;
    //性别
    private int gender;
    //头像
    private String head_portrait;

    private String pwd;
    //定义一个msg，发送消息
    private String msg;
    //判断是否成功
    private boolean success;
}
