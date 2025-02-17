package com.demo.kt.domain.sitter.repository;

import com.demo.kt.domain.member.model.Member;
import com.demo.kt.domain.sitter.model.PetSitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SitterRepository extends JpaRepository<PetSitter, Long> {

    PetSitter findByMember(Member member);
}
