package com.dgsw.cns.user.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 개인정보(성함, 생일, 성별, 전화번호)
 */
@Getter
@RequiredArgsConstructor
public class MemberInfoVO {

    private final String name;

    private final String birth;

    private final String gender;

    private final String telephone;

}
