package com.demo.kt.domain.sitter.model;

import com.demo.kt.domain.member.model.Member;
import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Getter;

@Entity
@Getter
public class PetSitter extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "pet_sitter_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String location;
    private LocalDateTime workableStart;
    private LocalDateTime workableEnd;
    private Long price;
    private String profileImage;
    // TODO 등록상태

}
