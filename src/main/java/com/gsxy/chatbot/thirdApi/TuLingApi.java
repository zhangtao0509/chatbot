package com.gsxy.chatbot.thirdApi;

import com.alibaba.fastjson.JSONObject;
import com.gsxy.chatbot.thirdApi.bean.*;
import com.gsxy.chatbot.util.HttpClientUtil;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图灵机器人相关接口
 */
@Component
public class TuLingApi {
    /**
     * 接口地址
     */
    private static final String url = "http://openapi.tuling123.com/openapi/api/v2";
    /**
     * 机器人的apiKey
     */
    private static final String apiKey = "9e2c277130c442a3a6ea1573d8afc2ea";

    private static final String default_message = "我还在学习中，不理解你这样说得意思";

    /**
     * 机器人聊天接口w
     *
     * @param message
     * @param userId
     * @return
     */
    public List<Result> sendMessage(String message, String userId) {
        List<Result> results = new ArrayList<>();
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("reqType", 0);
        paramMap.put("perception", new Perception(new InputText(message)));
        paramMap.put("userInfo", new UserInfo(apiKey, userId));
        HttpClientUtil.HttpResponse httpResponse = HttpClientUtil.httpPostRaw(url, JSONObject.toJSONString(paramMap), new HashMap<>(), "UTF-8");
        String body = httpResponse.getBody();
        SendMessageResponDTO sendMessageResponDTO = JSONObject.parseObject(body, SendMessageResponDTO.class);
        if (sendMessageResponDTO != null && !CollectionUtils.isEmpty(sendMessageResponDTO.getResults())
                && sendMessageResponDTO.getResults().get(0).getValues() != null) {
            results = sendMessageResponDTO.getResults();
        } else {
            //如果接口调用失败，或无返回默认回复
            results.add(new Result("text", new Values(default_message)));
        }
        return results;
    }
}
