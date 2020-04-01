package com.gsxy.chatbot.thirdApi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 直接输入文本
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InputText {
    /**
     * 1-128字符
     */
    private String text;
}
