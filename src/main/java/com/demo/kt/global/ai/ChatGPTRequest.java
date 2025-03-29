package com.demo.kt.global.ai;

import java.util.List;

public record ChatGPTRequest(
        String model,
        List<Message> messages
) {

    public ChatGPTRequest(String model, String prompt) {
        this(model, List.of(new Message("user", prompt)));
    }
}
