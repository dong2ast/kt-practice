package com.demo.kt.domain.member.dto;

import com.demo.kt.domain.member.model.Member;

public record MemberDetailDto(
        String email,
        String name,
        String phone
) {

    public static MemberDetailDto of(Member member) {
        return new MemberDetailDto(member.getEmail(), member.getName(), member.getPhone());
    }
}
