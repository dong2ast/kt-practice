package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.sitter.model.DogSizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogSizeRepository extends JpaRepository<DogSizeEntity, Long> {

}
