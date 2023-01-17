package com.dgsw.cns.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 회원(지원자)의 학교 정보(졸업예정, 졸업, 검정고시) 관련 정보들을 담고 있는 추상 클래스
 * @see com.dgsw.cns.user.vo.school.UngraduatedInfoVO
 * @see com.dgsw.cns.user.vo.school.GraduatedInfoVO
 * @see com.dgsw.cns.user.vo.school.QualifiedInfoRO
 */
@Getter
@ToString
@AllArgsConstructor
public abstract class MemberSchoolInfoRO {

    public abstract Type getType();

    protected enum Type {
        /**
         * 졸업예정
         */
        UNGRADUATED,

        /**
         * 졸업
         */
        GRADUATED,

        /**
         * 검정고시
         */
        QUALIFICATION
    }

}
