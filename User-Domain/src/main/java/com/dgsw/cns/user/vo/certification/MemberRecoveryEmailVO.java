package com.dgsw.cns.user.vo.certification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 아이디를 조회했을 때, 반환하는 Value Object class
 * @see MemberRecoveryIdVO
 */
@Getter
@RequiredArgsConstructor
public class MemberRecoveryEmailVO {

    private final String email;

}
