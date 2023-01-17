package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberRegistrationVO;

/**
 * 유저 회원가입 API 인터페이스.
 * @see MemberRegistrationVO
 */
public interface UserRegistrationApi {

    /**
     * 이메일, 비밀번호, 이메일 인증 코드 6자리를 사용하여, 회원가입을 진행합니다.
     * @param memberRegistrationVO 이메일, 비밀번호, 이메일 인증 코드 객체
     */
    void registerUser(MemberRegistrationVO memberRegistrationVO);

}
