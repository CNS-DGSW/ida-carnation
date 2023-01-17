package com.dgsw.cns.user.vo.certification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 아이디(이메일)을 찾기 위한 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberRecoveryIdVO {

    private final String name;

    private final String birth;

}
