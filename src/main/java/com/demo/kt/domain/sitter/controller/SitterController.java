package com.demo.kt.domain.sitter.controller;

import com.demo.kt.domain.sitter.dto.SitterHomeDto;
import com.demo.kt.domain.sitter.dto.SitterRegistrationDto;
import com.demo.kt.domain.sitter.service.SitterService;
import com.demo.kt.global.common.dto.ApiResponse;
import com.demo.kt.global.enums.SuccessType;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sitters")
public class SitterController implements SitterApi {

    private final SitterService sitterService;

    @Override
    @PostMapping
    public ResponseEntity<ApiResponse<?>> registration(Principal principal,
            SitterRegistrationDto sitterRegistrationDto) {
        sitterService.registration(principal.getName(), sitterRegistrationDto);
        return ResponseEntity.ok(ApiResponse.success(SuccessType.SIGNUP_SUCCESS));
    }

    @Override
    @GetMapping
    public ResponseEntity<ApiResponse<SitterHomeDto>> home(Principal principal) {
        return ResponseEntity.ok(ApiResponse.success(SuccessType.SITTER_HOME_SUCCESS,
                sitterService.home(principal.getName())));
    }
}
