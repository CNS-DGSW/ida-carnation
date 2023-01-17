package com.dgsw.cns.user.vo.certification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 비밃번호를 재설정해야할 때, 필요한 정보들을 담은 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberRecoveryPasswordVO {

    private final String email;

    private final String newPassword;

    private final String verificationCode;

}
