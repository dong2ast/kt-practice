package com.demo.kt.domain.member.controller;

import com.demo.kt.domain.member.dto.LoginRequestDto;
import com.demo.kt.domain.member.dto.MemberInfoDto;
import com.demo.kt.domain.member.dto.SignUpDto;
import com.demo.kt.global.common.dto.ApiResponse;
import com.demo.kt.global.security.jwt.TokenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.security.Principal;
import org.springframework.http.ResponseEntity;

@Tag(name = "Member", description = "회원 API")
public interface MemberApi {

    @Operation(summary = "회원가입")
    ResponseEntity<ApiResponse<String>> singUp(SignUpDto signUpDto);

    @Operation(summary = "로그인")
    ResponseEntity<ApiResponse<TokenDto>> login(LoginRequestDto loginRequestDto);

    @Operation(summary = "로그아웃")
    @SecurityRequirement(name = "JWT Authorization")
    ResponseEntity<ApiResponse<?>> logout(Principal principal);

    @Operation(summary = "회원 정보 수정")
    @SecurityRequirement(name = "JWT Authorization")
    ResponseEntity<ApiResponse<MemberInfoDto>> update(Principal principal, MemberInfoDto memberInfoDto);
}
