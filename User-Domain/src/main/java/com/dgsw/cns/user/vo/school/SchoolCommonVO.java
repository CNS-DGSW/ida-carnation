package com.dgsw.cns.user.vo.school;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 지원자의 상태가 졸업 예정 혹은 졸업인 경우, 반드시 가져야하는 클래스
 */
@Getter
@RequiredArgsConstructor
public class SchoolCommonVO {

    private final String schoolCode;

    private final String region;

    private final String city;

    private final String telephone;

}
