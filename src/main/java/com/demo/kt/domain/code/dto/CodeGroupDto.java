package com.demo.kt.domain.code.dto;

import com.demo.kt.domain.code.model.CodeGroup;

public record CodeGroupDto(
        String id,
        String groupName,
        String description
) {

    public static CodeGroupDto of(CodeGroup codeGroup) {
        return new CodeGroupDto(codeGroup.getId(), codeGroup.getGroupName(),
                codeGroup.getDescription());
    }
}
