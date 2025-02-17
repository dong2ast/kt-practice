package com.demo.kt.domain.sitter.dto;

import com.demo.kt.domain.sitter.model.PetSitterServices;

public record SitterServiceResponseDto(
        Long id,
        String location,
        String species,
        Long price,
        String image
) {

    public static SitterServiceResponseDto of(PetSitterServices petSitterServices) {
        return new SitterServiceResponseDto(petSitterServices.getId(),
                petSitterServices.getLocation(),
                petSitterServices.getLocation(),
                petSitterServices.getPrice(), petSitterServices.getImage());
    }
}
