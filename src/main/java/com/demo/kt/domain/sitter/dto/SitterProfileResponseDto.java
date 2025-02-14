package com.demo.kt.domain.sitter.dto;

import com.demo.kt.domain.sitter.model.PetSitter;
import java.time.LocalDate;

public record SitterProfileResponseDto(
        String name,
        String location,
        String species,
        LocalDate startDate,
        LocalDate endDate,
        Long price,
        Boolean isRegister
) {

    public static SitterProfileResponseDto of(String name, PetSitter petSitter) {
        return new SitterProfileResponseDto(name, petSitter.getLocation(),
                petSitter.getSpecies(), petSitter.getWorkableStart(), petSitter.getWorkableEnd(),
                petSitter.getPrice(), petSitter.getIsRegistered());
    }
}
