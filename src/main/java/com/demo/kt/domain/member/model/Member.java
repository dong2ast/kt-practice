package com.demo.kt.domain.member.model;

import com.demo.kt.domain.sitter.model.PetSitter;
import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    private String phone;

    @Setter
    @OneToOne(mappedBy = "member")
    private PetSitter petSitter;

    public void updateProfile(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Boolean isSitter() {
        return petSitter != null;
    }

}
