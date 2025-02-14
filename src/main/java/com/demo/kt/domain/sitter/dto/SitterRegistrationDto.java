package com.demo.kt.domain.sitter.dto;

import java.time.LocalDate;

public record SitterRegistrationDto(
    String location,
    String species,
    LocalDate startDate,
    LocalDate endDate,
    Long price
) {

}
