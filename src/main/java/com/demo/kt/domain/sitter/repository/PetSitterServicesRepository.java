package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.sitter.model.PetSitter;
import com.demo.kt.domain.sitter.model.PetSitterServices;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetSitterServicesRepository extends JpaRepository<PetSitterServices, Long> {


    List<PetSitterServices> findAllByPetSitter(PetSitter petSitter);
}
