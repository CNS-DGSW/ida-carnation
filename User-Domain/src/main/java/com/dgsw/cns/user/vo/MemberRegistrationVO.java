package com.dgsw.cns.user.vo;

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
    private final String email;

    /**
     * 비밀번호 (8자리 이상 / 특수 문자 포함)
     */
    private final String password;

    /**
     * 이메일 인증 코드 6자리
     */
    private final String verificationCode;
}
