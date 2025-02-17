package com.demo.kt.domain.code.controller;

import com.demo.kt.domain.code.dto.CodeDetailDto;
import com.demo.kt.domain.code.dto.CodeGroupDto;
import com.demo.kt.domain.code.service.CodeService;
import com.demo.kt.global.common.dto.ApiResponse;
import com.demo.kt.global.enums.SuccessType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CodeController implements CodeApi{

    private final CodeService codeService;


    @Override
    @GetMapping("/code-groups")
    public ResponseEntity<ApiResponse<List<CodeGroupDto>>> getGroups() {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.GET_CODE_GROUPS_SUCCESS, codeService.getGroups()));
    }

    @Override
    @PostMapping("/code-groups")
    public ResponseEntity<ApiResponse<CodeGroupDto>> createGroups(@RequestBody CodeGroupDto codeGroupDto) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.CREATE_CODE_GROUP_SUCCESS, codeService.createGroups(codeGroupDto)));
    }

    @PutMapping("/code-groups/{id}")
    @Override
    public ResponseEntity<ApiResponse<CodeGroupDto>> updateGroups(@PathVariable(name = "id") String id, @RequestBody CodeGroupDto codeGroupDto) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.UPDATE_CODE_GROUPS_SUCCESS, codeService.updateGroups(id, codeGroupDto)));
    }

    @Override
    @DeleteMapping("/code-groups/{id}")
    public ResponseEntity<ApiResponse<?>> deleteGroups(@PathVariable(name = "id") String id) {
        codeService.deleteGroups(id);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.DELETE_CODE_GROUP_SUCCESS));
    }

    @Override
    @GetMapping("/code-details")
    public ResponseEntity<ApiResponse<List<CodeDetailDto>>> getCodeDetail(@RequestParam String groupId) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.GET_CODE_DETAIL_SUCCESS, codeService.getDetails(groupId)));
    }

    @Override
    @PostMapping("/code-details")
    public ResponseEntity<ApiResponse<CodeDetailDto>> createCodeDetail(@RequestBody CodeDetailDto codeDetailDto) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.CREATE_CODE_DETAIL_SUCCESS, codeService.createDetails(codeDetailDto)));
    }

    @Override
    @PutMapping("/code-details/{id}")
    public ResponseEntity<ApiResponse<CodeDetailDto>> updateCodeDetail(
            @PathVariable(name = "id") String id, @RequestBody CodeDetailDto codeDetailDto) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.UPDATE_CODE_DETAIL_SUCCESS, codeService.updateDetails(id, codeDetailDto)));
    }

    @Override
    @DeleteMapping("code-details/{id}")
    public ResponseEntity<ApiResponse<?>> deleteCodeDetail(@PathVariable(name = "id") String id) {
        codeService.deleteDetails(id);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.DELETE_CODE_DETAIL_SUCCESS));
    }
}
