package com.gsxy.chatbot.thirdApi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    /**
     * 组’编号:0为独立输出，大于0时可能包含同组相关内容 (如：音频与文本为一组时说明内容一致)
     */
    private int groupType;

    /**
     * 文本(text);连接(url);音频(voice);视频(video);图片(image);图文(news)
     */
    private String resultType;

    /**
     * 输出值
     */
    private Values values;

    public Result(String resultType, Values values) {
        this.resultType = resultType;
        this.values = values;
    }
}
