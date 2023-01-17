package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberSchoolInfoRO;

/**
 * 유저(지원생)의 학교 정보를 조회 및 입력하는 API 인터페이스.
 * @see MemberSchoolInfoRO
 */
public interface UserSchoolApi {

    MemberSchoolInfoRO getSchoolInfo(Long userId);

    void modifySchoolInfo(MemberSchoolInfoRO infoRO);

}
