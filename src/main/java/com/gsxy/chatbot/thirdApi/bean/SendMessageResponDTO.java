package com.gsxy.chatbot.thirdApi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageResponDTO {
    /**
     * 请求意图
     */
    private Intent intent;

    /**
     * 输出结果集
     */
    private List<Result> results;
}
