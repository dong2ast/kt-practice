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
    LOGIN_SUCCESS(HttpStatus.OK, "로그인에 성공하였습니다."),
    LOGOUT_SUCCESS(HttpStatus.OK, "로그아웃에 성공하였습니다."),
    UPDATE_INFO_SUCCESS(HttpStatus.OK, "회원 정보 수정에 성공하였습니다."),
    MEMBER_DETAIL_SUCCESS(HttpStatus.OK, "회원 상세 조회에 성공하였습니다."),
    SITTER_HOME_SUCCESS(HttpStatus.OK, "펫시터 홈 조회에 성공하였습니다."),
    SITTER_PROFILE_SUCCESS(HttpStatus.OK, "펫시터 프로필 조회에 성공하였습니다."),
    SITTER_PROFILE_UPDATE_SUCCESS(HttpStatus.OK, "펫시터 프로필 수정에 성공하였습니다."),
    GET_CODE_GROUPS_SUCCESS(HttpStatus.OK, "코드 그룹 조회에 성공하였습니다."),
    GET_CODE_DETAIL_SUCCESS(HttpStatus.OK, "코드 상세 조회에 성공하였습니다."),
    UPDATE_CODE_GROUPS_SUCCESS(HttpStatus.OK, "코드 그룹 수정에 성공하였습니다."),
    UPDATE_CODE_DETAIL_SUCCESS(HttpStatus.OK, "코드 상세 수정에 성공하였습니다."),
    GET_SITTER_SERVICE_SUCCESS(HttpStatus.OK, "서비스 목록 조회에 성공하였습니다."),
    GET_SERVICE_DETAIL_SUCCESS(HttpStatus.OK, "서비스 상세 조회에 성공하였습니다."),
    UPDATE_SERVICE_DETAIL_SUCCESS(HttpStatus.OK, "서비스 상세 수정에 성공하였습니다."),

    /**
     * 201 OK
     */
    SIGNUP_SUCCESS(HttpStatus.CREATED, "회원가입에 성공하였습니다"),
    SITTER_REGISTRATION_SUCCESS(HttpStatus.CREATED, "펫시터 등록에 성공하였습니다"),
    CREATE_CODE_GROUP_SUCCESS(HttpStatus.CREATED, "코드 그룹 생성에 성공하였습니다"),
    CREATE_CODE_DETAIL_SUCCESS(HttpStatus.CREATED, "코드 상세 생성에 성공하였습니다"),
    CREATE_SERVICE_SUCCESS(HttpStatus.CREATED, "서비스 등록에 성공하였습니다"),
    CREATE_BOOK_SUCCESS(HttpStatus.CREATED, "서비스 예약 요청에 성공하였습니다"),

    /**
     * 204 OK
     */
    WITHDRAW_SUCCESS(HttpStatus.NO_CONTENT, "회원 탈퇴에 성공하였습니다"),
    DELETE_SITTER_PROFILE_SUCCESS(HttpStatus.NO_CONTENT, "펫시터 탈퇴에 성공하였습니다"),
    DELETE_CODE_GROUP_SUCCESS(HttpStatus.NO_CONTENT, "코드 그룹 삭제에 성공하였습니다"),
    DELETE_CODE_DETAIL_SUCCESS(HttpStatus.NO_CONTENT, "코드 상세 삭제에 성공하였습니다"),
    DELETE_SERVICE_SUCCESS(HttpStatus.NO_CONTENT, "서비스 삭제에 성공하였습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }
}
