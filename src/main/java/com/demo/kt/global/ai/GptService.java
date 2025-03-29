package com.demo.kt.global.ai;

import org.springframework.stereotype.Service;

@Service
public class GptService {

    public String generatePrompt(String data) {
        // Diary diary = diaryRepository.findById(memberId) 와 같은 형태로 관찰일지를 불러와 데이터 활용 가능
        String diary = "까미, 5개월, 수컷, 포메라니안\n2025년3월14일, 오늘은 까미가 오른쪽 다리를"
                + "절뜩거렸다. 병원에 가보니 높은 곳에서 떨어진 충격 때문에 인대에 손상이 생긴 것 같다고 하셨다."
                + "강아지가 올라오기에는 침대 높이가 너무 높았던 것 같다... 얼렁 까미 전용 계단 만들어줘야지ㅜ";

        StringBuilder prompt = new StringBuilder();

        prompt.append("나는 강아지를 키우는 반려인이야. 강아지 이름, 나이, 성별, 품종과 같은 강아지에 대한 기본적인 정보와 함께"
                + "날짜, 관찰 내용이 적혀있는 날짜별 강아지 관찰 일지들을 제공할거야.\n"
                + "너는 수의사의 비서로서 강아지와 관련된 정보를 체계적으로 요약해서 전달함으로써 강아지 진료에 도움을 줄 수 있어야해.");

        prompt.append(diary);
        prompt.append("\n\n그리고 아래는 오늘 병원을 방문한 이유야.\n");
        prompt.append(data);

        return prompt.toString();
    }

}
