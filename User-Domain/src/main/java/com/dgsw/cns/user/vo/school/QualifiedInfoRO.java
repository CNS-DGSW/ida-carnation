package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.MemberSchoolInfoRO;
import com.dgsw.cns.user.vo.school.advanced.YearVO;
import lombok.Getter;

@Getter
public class QualifiedInfoRO extends MemberSchoolInfoRO {

    private final YearVO qualification;

    public QualifiedInfoRO(int year) {
        this(new YearVO(year));
    }

    public QualifiedInfoRO(YearVO qualification) {
        this.qualification = qualification;
    }

    @Override
    public Type getType() {
        return Type.QUALIFICATION;
    }
}
