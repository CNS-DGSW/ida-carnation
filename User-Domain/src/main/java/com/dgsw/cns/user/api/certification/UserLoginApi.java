package com.dgsw.cns.user.api.certification;

import com.dgsw.cns.user.vo.certification.MemberLoginVO;
import com.dgsw.cns.user.vo.certification.TokenVO;

/**
 * 유저 로그인 API 인터페이스
 * @see com.dgsw.cns.user.vo.certification.MemberLoginVO
 * @see com.dgsw.cns.user.vo.certification.TokenVO
 */
public interface UserLoginApi {

    TokenVO userLogin(MemberLoginVO memberLoginVO);

}
