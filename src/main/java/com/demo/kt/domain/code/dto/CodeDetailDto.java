package com.demo.kt.domain.code.dto;

import com.demo.kt.domain.code.model.CodeDetail;

public record CodeDetailDto(
        String codeId,
        String groupId,
        String codeName,
        String codeValue,
        Integer sortOrder,
        Boolean isActive
) {

    public static CodeDetailDto of(CodeDetail codeDetail) {
        return new CodeDetailDto(codeDetail.getId(), codeDetail.getId(),
                codeDetail.getCodeName(), codeDetail.getCodeValue(), codeDetail.getSortedOrder(),
                codeDetail.getIsActive());
    }
}
