package com.demo.kt.domain.member.service;

import com.demo.kt.domain.member.dto.LoginRequestDto;
import com.demo.kt.domain.member.dto.MemberInfoDto;
import com.demo.kt.domain.member.dto.SignUpDto;
import com.demo.kt.domain.member.model.Member;
import com.demo.kt.domain.member.repository.MemberRepository;
import com.demo.kt.global.enums.ErrorType;
import com.demo.kt.global.exception.model.CustomException;
import com.demo.kt.global.security.jwt.JwtProvider;
import com.demo.kt.global.security.jwt.TokenDto;
import com.demo.kt.global.security.utils.UserAuthentication;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String signUp(SignUpDto signUpDto) {
        if (memberRepository.existsByEmail(signUpDto.email())) {
            throw new CustomException(ErrorType.ALREADY_EXIST_USER);
        }

        return memberRepository.save(signUpDto.toMember(passwordEncoder)).getEmail();
    }

    @Transactional
    public TokenDto login(LoginRequestDto loginRequestDto) {
        Member member = memberRepository.findByEmail(loginRequestDto.email())
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR));

        if (!passwordEncoder.matches(loginRequestDto.password(), member.getPassword())) {
            throw new CustomException(ErrorType.WRONG_ID_PASSWORD);
        }

        return jwtProvider.issueToken(new UserAuthentication(loginRequestDto.email(),
                null, null));
    }

    @Transactional
    public void logout(String email) {
        jwtProvider.deleteRefreshToken(email);
    }

    @Transactional
    public MemberInfoDto update(String email, MemberInfoDto memberInfoDto) {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException(ErrorType.NOT_FOUND_MEMBER_ERROR));

        member.updateProfile(memberInfoDto.name(), memberInfoDto.phone());
        return MemberInfoDto.of(member);
    }


}
