package com.dgsw.cns.user.vo.school.advanced;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 지원자가 졸업예정자인 경우에 반드시 필요한 담임선생님의 간단 정보들을 담은 클래스
 */
@Getter
@RequiredArgsConstructor
public class TeacherVO {

    private final String name;

    private final String telephone;

}
