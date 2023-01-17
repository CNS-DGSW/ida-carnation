package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.school.advanced.YearVO;
import lombok.Getter;

@Getter
public class GraduatedInfoVO extends SchoolInfo {

    /**
     * 졸업한 년도
     */
    private final YearVO graduated;

    public GraduatedInfoVO(String code, String region, String city, String telephone,
                           int year) {
        this(code, region, city, telephone, new YearVO(year));
    }

    public GraduatedInfoVO(String code, String region, String city, String telephone,
                           YearVO graduated) {
        super(code, region, city, telephone);
        this.graduated = graduated;
    }

    @Override
    public Type getType() {
        return Type.GRADUATED;
    }
}
