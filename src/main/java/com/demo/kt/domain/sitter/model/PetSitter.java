package com.demo.kt.domain.sitter.model;

import com.demo.kt.domain.member.model.Member;
import com.demo.kt.domain.sitter.dto.SitterProfileUpdateDto;
import com.demo.kt.domain.sitter.dto.SitterRegistrationDto;
import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PetSitter extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "pet_sitter_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String location;
    private String species;
    private LocalDate workableStart;
    private LocalDate workableEnd;
    private Long price;
    private String profileImage;
    private Boolean isRegistered;

    public static PetSitter of(SitterRegistrationDto sitterRegistrationDto, Member member) {
        return PetSitter.builder()
                .location(sitterRegistrationDto.location())
                .species(sitterRegistrationDto.species())
                .workableStart(sitterRegistrationDto.startDate())
                .workableEnd(sitterRegistrationDto.endDate())
                .price(sitterRegistrationDto.price())
                .isRegistered(true) // 일단 바로 승인되게 설정
                .member(member)
                .build();
    }

    public void updateProfile(SitterProfileUpdateDto sitterProfileUpdateDto) {
        this.location = sitterProfileUpdateDto.location();
        this.species = sitterProfileUpdateDto.species();
        this.workableStart = sitterProfileUpdateDto.startDate();
        this.workableEnd = sitterProfileUpdateDto.endDate();
        this.price = sitterProfileUpdateDto.price();
    }

}
