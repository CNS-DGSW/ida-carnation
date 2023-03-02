package com.dgsw.cns.user.vo.certification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 비밃번호를 재설정해야할 때, 필요한 정보들을 담은 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberRecoveryPasswordVO {

    @NotNull
    @Email(message = "이메일의 유효성과 일치하지 않습니다.",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private final String email;

    @Size(min = 8, message = "비밀번호는 최소 8자리 이상입니다.")
    private final String newPassword;

    @Size(min = 6, max = 6, message = "인증코드는 6자리입니다.")
    private final String verificationCode;

}
