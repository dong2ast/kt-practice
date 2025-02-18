package com.demo.kt.domain.sitter.dto;

import java.util.List;

public record SitterHomeDto(
        Boolean isSitter,
        List<SitterServiceResponseDto> sitterServiceResponseDtos
) {

}
