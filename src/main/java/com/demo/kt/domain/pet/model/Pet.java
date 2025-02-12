package com.demo.kt.domain.pet.model;

import com.demo.kt.domain.member.model.Member;
import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Pet extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    private String name;
    private Integer age;
    private String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
