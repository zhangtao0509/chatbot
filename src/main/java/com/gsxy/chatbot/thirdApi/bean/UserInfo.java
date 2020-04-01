package com.gsxy.chatbot.thirdApi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    /**
     *机器人标识 (Y)
     */
    private String apiKey;
    /**
     *用户唯一标识(长度小于等于32位)(Y)
     */
    private String userId;
    /**
     *群聊唯一标识(长度小于等于64位)(N)
     */
    private String groupId;
    /**
     *群内用户昵称(长度小于等于64位)(N)
     */
    private String userIdName;

    public UserInfo(String apiKey, String userId) {
        this.apiKey = apiKey;
        this.userId = userId;
    }
}
