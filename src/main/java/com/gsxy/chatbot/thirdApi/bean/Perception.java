package com.gsxy.chatbot.thirdApi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 输入信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perception {
    /**
     * 直接输入文本(N)
     */
    private InputText inputText;
    /**
     * 图片地址(N)
     */
    private InputImage inputImage;
    /**
     * 音频地址(N)
     */
    private InputMedia inputMedia;
    /**
     * 地理位置信息(N)
     */
    private SelfInfo selfInfo;

    public Perception(InputText inputText) {
        this.inputText = inputText;
    }
}
