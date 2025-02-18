package com.demo.kt.domain.sitter.dto;

import com.demo.kt.domain.sitter.model.PetSitter;
import com.demo.kt.domain.sitter.model.PetSitterServices;
import java.util.List;

public record ServiceDetailResponseDto(
        Long id,
        String location,
        String species,
        Long price,
        List<ScheduleDto> schedule,
        Boolean isOwner
) {

    public static ServiceDetailResponseDto of(PetSitter petSitter,
            PetSitterServices petSitterServices, List<ScheduleDto> scheduleDtos, Boolean isOwner) {
        return new ServiceDetailResponseDto(petSitterServices.getId(),
                petSitterServices.getLocation(),
                petSitterServices.getSpecies(), petSitterServices.getPrice(), scheduleDtos,
                isOwner);
    }
}
