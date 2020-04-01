package com.gsxy.chatbot.thirdApi.bean;

import lombok.Data;

@Data
public class Location {
    /**
     * 城市
     */
    private String city;
    /**
     * 省
     */
    private String province;
    /**
     * 街道
     */
    private String street;
}
