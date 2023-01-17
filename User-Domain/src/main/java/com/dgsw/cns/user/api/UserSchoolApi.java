package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberSchoolInfoRO;

/**
 * 유저(지원생)의 학교 정보를 조회 및 입력하는 API 인터페이스.
 * @see MemberSchoolInfoRO
 * @see com.dgsw.cns.user.vo.school.UngraduatedInfoVO
 * @see com.dgsw.cns.user.vo.school.GraduatedInfoVO
 * @see com.dgsw.cns.user.vo.school.QualifiedInfoRO
 */
public interface UserSchoolApi {

    /**
     * 지원생의 학교 정보를 조회합니다.
     * @param userId 지원생 식별키(PK)
     * @return 학교 정보를 반환합니다.
     */
    MemberSchoolInfoRO getSchoolInfo(Long userId);

    /**
     * 지원생의 학교 정보를 수정 및 저장합니다.
     * @param infoRO 학교 정보
     */
    void modifySchoolInfo(MemberSchoolInfoRO infoRO);

}
