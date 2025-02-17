package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.sitter.model.ServiceTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceTypeEntity, Long> {

}
