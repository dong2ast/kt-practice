package com.demo.kt.global.exception;

import com.demo.kt.global.common.dto.ApiResponse;
import com.demo.kt.global.exception.model.CustomException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    /**
     * CUSTOM_ERROR
     */
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<ApiResponse<?>> handleCustomException(CustomException e) {

        log.warn("CustomException Occurred: {}", e.getMessage());

        return ResponseEntity.status(e.getHttpStatus())
                .body(ApiResponse.error(e.getErrorType()));
    }
}
