package com.demo.kt.domain.member.dto;

import com.demo.kt.domain.member.model.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

public record SignUpDto(
        @Email
        @NotBlank
        @Schema(example = "test1234@gmail.com")
        String email,
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z가-힣0-9!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?`~]{1,16}$",
         message = "특수문자, 영문, 한글, 숫자를 포함하여 16자 이내로 입력하세요.")
        @Schema(example = "@1234qwer")
        String password,
        @NotBlank
        @Size(min = 10, max = 11)
        @Schema(example = "01012345678")
        String phone,
        @Pattern(regexp = "^[가-힣]{1,16}$", message = "한글만 입력할 수 있으며, 16자 이내여야 합니다.")
        @Schema(example = "홍길동")
        String name
) {

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .phone(phone)
                .name(name)
                .build();
    }
}
