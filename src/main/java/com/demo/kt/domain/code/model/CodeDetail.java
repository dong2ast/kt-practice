package com.demo.kt.domain.code.model;

import com.demo.kt.domain.code.dto.CodeDetailDto;
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
public class CodeDetail extends BaseTimeEntity {

    @Id
    @Column(name = "code_id")
    private String id;

    private String groupId;

    private String codeName;
    private String codeValue;
    private Integer sortedOrder;
    private Boolean isActive;


    public static CodeDetail of(CodeDetailDto codeDetailDto) {
        return CodeDetail.builder()
                .id(codeDetailDto.codeId())
                .groupId(codeDetailDto.groupId())
                .codeName(codeDetailDto.codeName())
                .codeValue(codeDetailDto.codeValue())
                .sortedOrder(codeDetailDto.sortOrder())
                .isActive(codeDetailDto.isActive())
                .build();
    }

    public void update(CodeDetailDto codeDetailDto) {
        this.codeName = codeDetailDto.codeName();
        this.codeValue = codeDetailDto.codeValue();
        this.sortedOrder = codeDetailDto.sortOrder();
        this.isActive = codeDetailDto.isActive();
    }
}
