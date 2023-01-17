package com.dgsw.cns.user.vo.school;

import com.dgsw.cns.user.vo.school.advanced.TeacherVO;
import lombok.Getter;

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
