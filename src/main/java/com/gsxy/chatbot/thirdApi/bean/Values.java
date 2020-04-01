package com.gsxy.chatbot.thirdApi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Values {
    /**
     * 文本(text);连接(url);音频(voice);视频(video);图片(image);图文(news)
     */
    private String text;
    private String url;
    private String voice;
    private String video;
    private String image;
    private String news;

    public Values(String text) {
        this.text = text;
    }
}
