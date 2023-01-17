package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.MemberSchoolInfoRO;
import com.dgsw.cns.user.vo.school.advanced.YearVO;
import lombok.Getter;

/**
 * 지원자의 상태가 검정 고시인 경우를 구현한 자식 클래스
 * @see MemberSchoolInfoRO
 */
@Getter
public class QualifiedInfoRO extends MemberSchoolInfoRO {

    /**
     * 합격한 년도
     */
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
