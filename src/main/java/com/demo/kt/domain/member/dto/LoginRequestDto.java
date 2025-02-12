package com.demo.kt.domain.member.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public record LoginRequestDto(
        String email,
        String password
) {

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }

}
