package com.demo.kt.domain.sitter.controller;

import com.demo.kt.domain.sitter.dto.SitterHomeDto;
import com.demo.kt.domain.sitter.dto.SitterRegistrationDto;
import com.demo.kt.global.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.security.Principal;
import org.springframework.http.ResponseEntity;

@Tag(name = "Sitter", description = "펫시터 API")
public interface SitterApi {

    @Operation(summary = "펫시터 등록")
    @SecurityRequirement(name = "JWT Authorization")
    ResponseEntity<ApiResponse<?>> registration(Principal principal,
            SitterRegistrationDto sitterRegistrationDto);

    @Operation(summary = "펫시터 홈")
    @SecurityRequirement(name = "JWT Authorization")
    ResponseEntity<ApiResponse<SitterHomeDto>> home(Principal principal);
}
