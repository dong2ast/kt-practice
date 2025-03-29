package com.demo.kt.global.ai;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ai")
@RequiredArgsConstructor
public class GptController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    private final RestTemplate template;
    private final GptService gptService;


    @GetMapping("/chat")
    public String chat(
            @RequestParam(name = "prompt") @Schema(example = "오늘 갑자기 까미가 다리를 절뚝거리는 것 같아서 병원에 왔습니다.") String prompt) {
        ChatGPTRequest request = new ChatGPTRequest(model, gptService.generatePrompt(prompt));
        ChatGPTResponse chatGPTResponse = template.postForObject(apiURL, request,
                ChatGPTResponse.class);
        return chatGPTResponse.choices().getFirst().message().content();
    }
}
