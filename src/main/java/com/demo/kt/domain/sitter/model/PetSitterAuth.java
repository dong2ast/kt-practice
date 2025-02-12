package com.demo.kt.domain.sitter.model;

import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class PetSitterAuth extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "pet_sitter_auth_id")
    private Long id;
}
