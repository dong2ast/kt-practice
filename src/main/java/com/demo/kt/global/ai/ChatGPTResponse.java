package com.demo.kt.global.ai;

import java.util.List;

public record ChatGPTResponse(
        List<Choice> choices
) {

    public record Choice(
            int index,
            Message message
    ) {

    }
}
