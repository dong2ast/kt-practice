package com.demo.kt.domain.sitter.dto;

import com.demo.kt.domain.sitter.enums.DogSize;
import com.demo.kt.domain.sitter.enums.ServiceType;
import java.util.List;

public record ServiceRegistrationDto(
    List<ServiceType> serviceTypes,
    List<DogSize> dogSizes,
    Long rate,
    List<ScheduleDto> schedule
) {

}
