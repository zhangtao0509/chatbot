package com.gsxy.chatbot.thirdApi.bean;

import lombok.Data;

/**
 * 请求意图
 */
@Data
public class Intent {
    /**
     * 输出功能code
     */
    private int code;

    /**
     * 意图名称
     */
    private String intentName;

    /**
     * 意图动作名称
     */
    private String actionName;

    /**
     * 功能相关参数
     */
    private Parameters parameters;
}
