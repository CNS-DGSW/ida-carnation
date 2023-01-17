package com.dgsw.cns.user.vo.certification;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원이 로그인 할 정보(이메일, 비밀번호)들을 담고 있는 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberLoginVO {

    private final String email;

    private final String password;

}
