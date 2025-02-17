package com.demo.kt.domain.code.service;

import com.demo.kt.domain.code.dto.CodeDetailDto;
import com.demo.kt.domain.code.dto.CodeGroupDto;
import com.demo.kt.domain.code.model.CodeDetail;
import com.demo.kt.domain.code.model.CodeGroup;
import com.demo.kt.domain.code.repository.CodeDetailRepository;
import com.demo.kt.domain.code.repository.CodeGroupRepository;
import com.demo.kt.global.enums.ErrorType;
import com.demo.kt.global.exception.model.CustomException;
import jakarta.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CodeService {

    private final CodeDetailRepository codeDetailRepository;
    private final CodeGroupRepository codeGroupRepository;

    public List<CodeGroupDto> getGroups() {
    return codeGroupRepository.findAll().stream()
        .sorted(Comparator.comparing(CodeGroup::getId)) // id 기준으로 정렬
        .map(CodeGroupDto::of)
        .toList();
}


    @Transactional
    public CodeGroupDto createGroups(CodeGroupDto codeGroupDto) {
        return CodeGroupDto.of(codeGroupRepository.save(CodeGroup.of(codeGroupDto)));
    }

    @Transactional
    public CodeGroupDto updateGroups(String id, CodeGroupDto codeGroupDto) {
        CodeGroup codeGroup = codeGroupRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_CODE_GROUPS_ERROR));
        codeGroup.update(codeGroupDto);
        return codeGroupDto;
    }

    @Transactional
    public void deleteGroups(String id) {
        codeGroupRepository.deleteById(id);
    }

    public List<CodeDetailDto> getDetails(String groupId) {
        return codeDetailRepository.findAllByGroupId(groupId).stream().map(CodeDetailDto::of).toList();
    }

    @Transactional
    public CodeDetailDto createDetails(CodeDetailDto codeDetailDto) {
        return CodeDetailDto.of(codeDetailRepository.save(CodeDetail.of(codeDetailDto)));
    }

    @Transactional
    public CodeDetailDto updateDetails(String id, CodeDetailDto codeDetailDto) {
        CodeDetail codeDetail = codeDetailRepository.findById(id)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_CODE_ERROR));
        codeDetail.update(codeDetailDto);
        return codeDetailDto;
    }

    @Transactional
    public void deleteDetails(String id) {
        codeDetailRepository.deleteById(id);
    }

}
