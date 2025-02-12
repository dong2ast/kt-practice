package com.demo.kt.domain.member.dto;

import com.demo.kt.domain.member.model.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public record SignUpDto(
        String email,
        String password,
        String phone,
        String name
) {

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .name(name)
                .build();
    }
}
