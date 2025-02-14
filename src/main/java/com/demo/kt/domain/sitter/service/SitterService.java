package com.demo.kt.domain.sitter.service;

import com.demo.kt.domain.member.model.Member;
import com.demo.kt.domain.member.repository.MemberRepository;
import com.demo.kt.domain.sitter.dto.SitterHomeDto;
import com.demo.kt.domain.sitter.dto.SitterProfileResponseDto;
import com.demo.kt.domain.sitter.dto.SitterProfileUpdateDto;
import com.demo.kt.domain.sitter.dto.SitterRegistrationDto;
import com.demo.kt.domain.sitter.model.PetSitter;
import com.demo.kt.domain.sitter.repository.SitterRepository;
import com.demo.kt.global.enums.ErrorType;
import com.demo.kt.global.exception.model.CustomException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SitterService {

    private final MemberRepository memberRepository;
    private final SitterRepository sitterRepository;

    @Transactional
    public void registration(String email, SitterRegistrationDto sitterRegistrationDto) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR));

        PetSitter petSitter = PetSitter.of(sitterRegistrationDto, member);
        member.setPetSitter(petSitter);
        sitterRepository.save(petSitter);
    }

    public SitterHomeDto home(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR));

        return new SitterHomeDto(member.isSitter());
    }

    public SitterProfileResponseDto profile(String email) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR));

        if (member.isSitter()) {
            return SitterProfileResponseDto.of(member.getName(), member.getPetSitter());
        }
        throw new CustomException(ErrorType.NOT_SITTER);
    }

    @Transactional
    public void update(String email, SitterProfileUpdateDto sitterProfileUpdateDto) {
        PetSitter petSitter = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR))
                .getPetSitter();

        petSitter.updateProfile(sitterProfileUpdateDto);
    }

}
