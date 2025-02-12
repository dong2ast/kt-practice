package com.demo.kt.global.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum SuccessType {

    /**
     * 200 OK
     */
    PROCESS_SUCCESS(HttpStatus.OK, "OK"),
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공하였습니다."),
    LOGOUT_SUCCESS(HttpStatus.OK, "로그아웃에 성공하였습니다."),
    MEMBER_DETAIL_SUCCESS(HttpStatus.OK, "회원 상세 조회에 성공하였습니다."),

    /**
     * 201 OK
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입에 성공하였습니다"),

    /**
     * 204 OK
     */
    WITHDRAW_SUCCESS(HttpStatus.NO_CONTENT, "회원 탈퇴에 성공하였습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
