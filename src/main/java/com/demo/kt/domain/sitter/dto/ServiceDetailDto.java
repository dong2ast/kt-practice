package com.demo.kt.domain.sitter.dto;

import java.util.List;

public record ServiceDetailDto(
        Long id,
        String location,
        String species,
        Long price,
        List<ScheduleDto> schedule
) {

}
