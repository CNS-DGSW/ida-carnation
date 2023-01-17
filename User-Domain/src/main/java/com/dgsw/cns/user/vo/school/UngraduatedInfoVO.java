package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.school.advanced.TeacherVO;
import lombok.Getter;

/**
 * 지원자의 상태가 졸업 예정인 것을 구현한 자식 클래스
 *
 * @see SchoolInfo
 * @see com.dgsw.cns.user.vo.MemberSchoolInfoRO
 */
@Getter
public class UngraduatedInfoVO extends SchoolInfo {

    private final TeacherVO teacher;

    public UngraduatedInfoVO(String code, String region, String city, String telephone,
                             String teacherName, String teacherTelephone) {
        this(code, region, city, telephone, new TeacherVO(teacherName, teacherTelephone));
    }

    public UngraduatedInfoVO(String code, String region, String city, String telephone,
                             TeacherVO teacher) {
        super(code, region, city, telephone);
        this.teacher = teacher;
    }

    @Override
    public Type getType() {
        return Type.UNGRADUATED;
    }
}
