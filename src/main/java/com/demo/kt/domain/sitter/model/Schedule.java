package com.demo.kt.domain.sitter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String day; // 월요일, 화요일...

    private String startTime; // HH:mm 형식

    private String endTime; // HH:mm 형식

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_sitter_services_id", nullable = false)
    private PetSitterServices services;
}
