package com.demo.kt.domain.member.controller;

import com.demo.kt.domain.member.dto.LoginRequestDto;
import com.demo.kt.domain.member.dto.MemberInfoDto;
import com.demo.kt.domain.member.dto.LoginResponseDto;
import com.demo.kt.domain.member.dto.MemberDetailDto;
import com.demo.kt.domain.member.dto.SignUpDto;
import com.demo.kt.domain.member.service.MemberService;
import com.demo.kt.global.common.dto.ApiResponse;
import com.demo.kt.global.enums.SuccessType;
import com.demo.kt.global.security.jwt.TokenDto;
import jakarta.validation.Valid;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController implements MemberApi {

    private final MemberService memberService;

    @Override
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> singUp(@RequestBody @Valid SignUpDto signUpDto) {
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.SIGNUP_SUCCESS, memberService.signUp(signUpDto)));
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(
            @RequestBody LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.LOGIN_SUCCESS,
                        memberService.login(loginRequestDto)));
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> logout(
            Principal principal) {
        memberService.logout(principal.getName());
        return ResponseEntity.ok(
                ApiResponse.success(SuccessType.LOGOUT_SUCCESS)
        );
    }

    @Override
    @PutMapping
    public ResponseEntity<ApiResponse<MemberInfoDto>> update(Principal principal, @RequestBody MemberInfoDto memberInfoDto) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.UPDATE_INFO_SUCCESS, memberService.update(
                principal.getName(), memberInfoDto)));
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ApiResponse<?>> withdraw(Principal principal) {
        memberService.withdraw(principal.getName());
        return ResponseEntity.ok(ApiResponse.success(SuccessType.WITHDRAW_SUCCESS));
    }

    @Override
    @GetMapping()
    public ResponseEntity<ApiResponse<MemberDetailDto>> detail(Principal principal) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.MEMBER_DETAIL_SUCCESS,
                memberService.detail(principal.getName())));
    }
}
