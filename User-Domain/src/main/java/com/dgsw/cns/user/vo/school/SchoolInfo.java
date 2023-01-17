package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.MemberSchoolInfoRO;
import lombok.Getter;

/**
 * 지원자의 상태가 졸업 예정자 혹은 졸업자인 경우, 공통적으로 가져야하는 추상 클래스
 * @see UngraduatedInfoVO
 * @see GraduatedInfoVO
 * @see MemberSchoolInfoRO
 * @see SchoolCommonVO
 */
@Getter
public abstract class SchoolInfo extends MemberSchoolInfoRO {

    protected final SchoolCommonVO schoolCommon;

    public SchoolInfo(String code, String region, String city, String telephone) {
        this.schoolCommon = new SchoolCommonVO(code, region, city, telephone);
    }
}
