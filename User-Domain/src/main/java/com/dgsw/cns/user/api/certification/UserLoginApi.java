package com.dgsw.cns.user.api.certification;

import com.dgsw.cns.user.vo.certification.MemberLoginVO;
import com.dgsw.cns.user.vo.certification.TokenVO;

/**
 * 유저 로그인 API 인터페이스
 * @see com.dgsw.cns.user.vo.certification.MemberLoginVO
 * @see com.dgsw.cns.user.vo.certification.TokenVO
 */
public interface UserLoginApi {

    /**
     * 이메일과 비밀번호로 로그인을 진행합니다.
     * @param memberLoginVO 이메일과 비밀번호
     * @return 회원 정보를 토대로 JWT 토큰을 반환합니다.
     */
    TokenVO userLogin(MemberLoginVO memberLoginVO);

}
