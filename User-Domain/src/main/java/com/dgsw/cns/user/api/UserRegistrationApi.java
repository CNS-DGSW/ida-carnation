package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberRegistrationVO;

/**
 * 유저 회원가입 API 인터페이스.
 * @see MemberRegistrationVO
 */
public interface UserRegistrationApi {

    void registerUser(MemberRegistrationVO memberRegistrationVO);

}
