package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.MemberSchoolInfoRO;
import lombok.Getter;

@Getter
public abstract class SchoolInfo extends MemberSchoolInfoRO {

    protected final SchoolCommonVO schoolCommon;

    public SchoolInfo(String code, String region, String city, String telephone) {
        this.schoolCommon = new SchoolCommonVO(code, region, city, telephone);
    }
}
