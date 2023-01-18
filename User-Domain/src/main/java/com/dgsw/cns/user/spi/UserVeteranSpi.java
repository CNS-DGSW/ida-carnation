package com.dgsw.cns.user.spi;

import com.dgsw.cns.user.vo.MemberVeteranVO;

/**
 * 국가 보훈 코드를 저장하고 조회하는 서비스 인터페이스
 */
public interface UserVeteranSpi {

    /**
     * 국가 보훈 코드를 조회합니다.
     * @param id 지원생 식별키(PK)
     * @return 조회한 보훈 정보를 반환합니다.
     */
    MemberVeteranVO getVeteranInfo(final long id);

    /**
     * 국가 보훈 코드 및 보훈청을 입력합니다.
     * @param id 지원생 식별키(PK)
     * @param department 국가 보훈청
     * @param veteranId 국가 보훈 번호
     */
    void updateVeteranInfo(final long id, final String department, final String veteranId);

}
