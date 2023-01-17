package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberInfoVO;

/**
 * 회원의 기본 정보(성함, 생일, 성별, 전화번호)를 조회하는 API 인터페이스
 * @see MemberInfoVO
 */
public interface UserInfoApi {

    /**
     * 회원의 기본 정보를 반환합니다.
     * @param memberId 회원의 식별키(PK)
     * @return 회원의 기본 정보
     */
    MemberInfoVO getUserInfo(Long memberId);

}
