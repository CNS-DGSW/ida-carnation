package com.dgsw.cns.user.vo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원 가입 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberRegistrationVO {

    /**
     * 이메일 주소
     */
    @NotNull
    @Email(message = "이메일의 유효성과 일치하지 않습니다.",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private final String email;

    /**
     * 비밀번호 (8자리 이상 / 특수 문자 포함)
     */
    @Size(min = 8, message = "비밀번호는 최소 8자리 이상입니다.")
    private final String password;

    /**
     * 이메일 인증 코드 6자리
     */
    @Size(min = 6, max = 6)
    private final String verificationCode;
}
