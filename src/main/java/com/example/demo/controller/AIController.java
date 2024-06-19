package com.example.demo.controller;

import com.alibaba.dashscope.aigc.conversation.Conversation;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import org.springframework.web.bind.annotation.*;
import com.alibaba.dashscope.aigc.conversation.ConversationParam;
import com.alibaba.dashscope.aigc.conversation.ConversationResult;
import com.alibaba.dashscope.utils.JsonUtils;

@RestController
@CrossOrigin(origins = "*")
public class AIController {

    private static final String API_KEY = "sk-9f3778e2e3bc4840b95e8f4687c65ced";  // 替换为你的实际 API Key

    public static String quickStart(String question) throws ApiException, NoApiKeyException, InputRequiredException {
        Conversation conversation = new Conversation();
        String prompt = question;
        ConversationParam param = ConversationParam
                .builder()
                .model(Conversation.Models.QWEN_TURBO)
                .prompt(prompt)
                .apiKey(API_KEY)
                .build();
        ConversationResult result = conversation.call(param);
        return JsonUtils.toJson(result);
    }
    @GetMapping("/ai")
    public String getAI(@RequestParam String question) {
        try {
            return quickStart(question);
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            return e.getMessage();
        }
    }

}
