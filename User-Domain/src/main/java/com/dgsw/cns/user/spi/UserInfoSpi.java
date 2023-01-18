package com.dgsw.cns.user.spi;

import com.dgsw.cns.user.vo.MemberInfoVO;

/**
 * 지원생의 기본 정보를 조회하는 서비스 인터페이스
 */
public interface UserInfoSpi {

    /**
     * 지원생의 기본 정보를 조회합니다.
     * <pre>
     *     - 이름
     *     - 생일
     *     - 성별
     *     - 전화번호
     * </pre>
     * @param id 지원생 식별키(PK)
     * @return 조회한 기본 정보를 반환합니다.
     */
    MemberInfoVO findUserInfo(final long id);

}
