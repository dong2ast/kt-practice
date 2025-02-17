package com.demo.kt.domain.sitter.controller;

import com.demo.kt.domain.sitter.dto.ServiceDetailDto;
import com.demo.kt.domain.sitter.dto.ServiceDetailResponseDto;
import com.demo.kt.domain.sitter.dto.ServiceRegistrationDto;
import com.demo.kt.domain.sitter.dto.SitterHomeDto;
import com.demo.kt.domain.sitter.dto.SitterProfileResponseDto;
import com.demo.kt.domain.sitter.dto.SitterProfileUpdateDto;
import com.demo.kt.domain.sitter.dto.SitterRegistrationDto;
import com.demo.kt.domain.sitter.dto.SitterServiceResponseDto;
import com.demo.kt.global.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.security.Principal;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Tag(name = "Sitter", description = "펫시터 API")
@SecurityRequirement(name = "JWT Authorization")
public interface SitterApi {

    @Operation(summary = "펫시터 등록")
    ResponseEntity<ApiResponse<?>> registration(Principal principal,
            SitterRegistrationDto sitterRegistrationDto);

    @Operation(summary = "펫시터 홈")
    ResponseEntity<ApiResponse<SitterHomeDto>> home(Principal principal);

    @Operation(summary = "펫시터 프로필 조회")
    ResponseEntity<ApiResponse<SitterProfileResponseDto>> profile(Principal principal);

    @Operation(summary = "펫시터 프로필 수정")
    ResponseEntity<ApiResponse<?>> update(Principal principal,
            SitterProfileUpdateDto sitterProfileUpdateDto);

    @Operation(summary = "펫시터 프로필 삭제")
    ResponseEntity<ApiResponse<?>> delete(Principal principal);

    @Operation(summary = "펫시터 서비스 등록")
    ResponseEntity<ApiResponse<?>> serviceRegistration(Principal principal,
            ServiceRegistrationDto serviceRegistrationDto);

    @Operation(summary = "펫시터 서비스 조회")
    ResponseEntity<ApiResponse<List<SitterServiceResponseDto>>> myServices(Principal principal);

    @Operation(summary = "펫시터 서비스 삭제")
    ResponseEntity<ApiResponse<?>> deleteService(Principal principal, Long id);

    @Operation(summary = "펫시터 서비스 상세 조회")
    ResponseEntity<ApiResponse<ServiceDetailResponseDto>> serviceDetail(Principal principal,
            Long id);

    @Operation(summary = "펫시터 서비스 수정")
    ResponseEntity<ApiResponse<?>> updateServiceDetail(Principal principal,
            ServiceDetailDto serviceDetailDto);
}
