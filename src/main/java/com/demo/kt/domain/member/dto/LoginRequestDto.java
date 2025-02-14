package com.demo.kt.domain.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record LoginRequestDto(
        @Schema(example = "test1234@gmail.com")
        String email,
        @Schema(example = "@1234qwer")
        String password
) {

}
