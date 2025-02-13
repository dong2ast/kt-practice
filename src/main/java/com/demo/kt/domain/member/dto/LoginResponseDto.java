package com.demo.kt.domain.member.dto;

import com.demo.kt.global.security.jwt.TokenDto;

public record LoginResponseDto(
        String name,
        TokenDto tokenDto
) {

}
