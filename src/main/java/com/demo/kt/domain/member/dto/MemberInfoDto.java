package com.demo.kt.domain.member.dto;

import com.demo.kt.domain.member.model.Member;

public record MemberInfoDto(
        String name,
        String phone
) {

    public static MemberInfoDto of(Member member) {
        return new MemberInfoDto(member.getName(), member.getPhone());
    }
}
