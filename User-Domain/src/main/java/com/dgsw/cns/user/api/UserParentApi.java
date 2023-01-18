package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberParentVO;

/**
 * 회원(지원생)의 부모 정보를 조회 및 저장, 수정하는 API 인터페이스
 * @see MemberParentVO
 */
public interface UserParentApi {

    /**
     * 지원생의 부모 정보를 조회합니다.
     * @param userId 지원생 식별키(PK)
     * @return 부모 정보를 반환합니다.
     */
    MemberParentVO getParentInfo(Long userId);

    /**
     * 지원생의 부모 정보를 수정 및 저장합니다.
     * @param userId 지원생 식별키(PK)
     * @param memberParentVO 부모 정보
     */
    void modifyParentInfo(Long userId, MemberParentVO memberParentVO);

}
