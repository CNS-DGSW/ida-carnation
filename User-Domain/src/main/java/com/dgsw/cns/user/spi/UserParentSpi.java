package com.dgsw.cns.user.spi;

import com.dgsw.cns.user.vo.MemberParentVO;

/**
 * 지원생의 부모 정보를 조회 및 수정하는 서비스 인터페이스
 */
public interface UserParentSpi {

    /**
     * 지원생의 부모 정보를 수정 및 저장합니다.
     * @param id 지원생 식별키(PK)
     * @param memberParentVO 지원생의 부모 정보
     */
    void modifyParentInfo(final long id, final MemberParentVO memberParentVO);

    /**
     * 지원생의 부모 정보를 조회합니다.
     * @param id 지원생 식별키(PK)
     * @return 조회한 부모 정보를 반환합니다.
     */
    MemberParentVO findParentInfoById(final long id);

}
