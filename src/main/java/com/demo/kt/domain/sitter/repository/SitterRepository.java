package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.sitter.model.PetSitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SitterRepository extends JpaRepository<PetSitter, Long> {

}
