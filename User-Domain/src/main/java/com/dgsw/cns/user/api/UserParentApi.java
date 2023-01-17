package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberParentVO;

/**
 * 회원(지원생)의 부모 정보를 조회 및 저장, 수정하는 API 인터페이스
 * @see MemberParentVO
 */
public interface UserParentApi {

    MemberParentVO getParentInfo(Long userId);

    void modifyParentInfo(MemberParentVO memberParentVO);

}
