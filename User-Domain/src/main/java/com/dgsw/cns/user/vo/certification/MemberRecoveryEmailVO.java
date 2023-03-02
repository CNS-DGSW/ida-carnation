package com.dgsw.cns.user.vo.certification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 아이디를 조회했을 때, 반환하는 Value Object class
 * @see MemberRecoveryIdVO
 */
@Getter
@RequiredArgsConstructor
public class MemberRecoveryEmailVO {

    @NotNull
    @Email(message = "이메일의 유효성과 일치하지 않습니다.",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private final String email;

}
