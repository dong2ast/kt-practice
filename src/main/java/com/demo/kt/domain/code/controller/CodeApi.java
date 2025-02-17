package com.demo.kt.domain.code.controller;

import com.demo.kt.domain.code.dto.CodeDetailDto;
import com.demo.kt.domain.code.dto.CodeGroupDto;
import com.demo.kt.global.common.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Tag(name = "Code", description = "코드 관리 API")
public interface CodeApi {

    @Operation(summary = "코드 그룹 조회")
    ResponseEntity<ApiResponse<List<CodeGroupDto>>> getGroups();

    @Operation(summary = "코드 그룹 추가")
    ResponseEntity<ApiResponse<CodeGroupDto>> createGroups(CodeGroupDto codeGroupDto);

    @Operation(summary = "코드 그룹 수정")
    ResponseEntity<ApiResponse<CodeGroupDto>> updateGroups(String id, CodeGroupDto codeGroupDto);

    @Operation(summary = "코드 그룹 삭제")
    ResponseEntity<ApiResponse<?>> deleteGroups(String id);

    @Operation(summary = "코드 상세 조회")
    ResponseEntity<ApiResponse<List<CodeDetailDto>>> getCodeDetail(String id);

    @Operation(summary = "코드 상세 추가")
    ResponseEntity<ApiResponse<CodeDetailDto>> createCodeDetail(CodeDetailDto codeDetailDto);

    @Operation(summary = "코드 상세 수정")
    ResponseEntity<ApiResponse<CodeDetailDto>> updateCodeDetail(String id, CodeDetailDto codeDetailDto);

    @Operation(summary = "코드 상세 삭제")
    ResponseEntity<ApiResponse<?>> deleteCodeDetail(String id);
}
