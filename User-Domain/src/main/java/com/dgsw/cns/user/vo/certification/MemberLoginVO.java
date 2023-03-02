package com.dgsw.cns.user.vo.certification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원이 로그인 할 정보(이메일, 비밀번호)들을 담고 있는 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberLoginVO {

    @NotNull
    @Email(message = "이메일의 유효성과 일치하지 않습니다.",
            regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private final String email;

    @Size(min = 8, message = "비밀번호는 최소 8자리 이상입니다.")
    private final String password;

}
