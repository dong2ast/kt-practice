package com.demo.kt.domain.code.model;

import com.demo.kt.domain.code.dto.CodeGroupDto;
import com.demo.kt.global.common.model.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CodeGroup extends BaseTimeEntity {

    @Id
    @Column(name = "group_id")
    private String id;

    private String groupName;
    private String description;

    public static CodeGroup of(CodeGroupDto codeGroupDto) {
        return CodeGroup.builder()
                .id(codeGroupDto.id())
                .groupName(codeGroupDto.groupName())
                .description(codeGroupDto.description())
                .build();
    }

    public void update(CodeGroupDto codeGroupDto) {
        this.groupName = codeGroupDto.groupName();
        this.description = codeGroupDto.description();
    }
}
