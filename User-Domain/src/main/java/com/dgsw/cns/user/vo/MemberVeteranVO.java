package com.dgsw.cns.user.vo;

import com.dgsw.cns.user.domain.Merit;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 국가 보훈 번호와 해당 부분들에 대한 정보들을 담고있는 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberVeteranVO {

    /**
     * 발급받은 보훈청 (ex. 대구지방보훈청)
     */
    private final String department;

    /**
     * 보훈 번호 (양식: xx-xxxxxx)
     */
    private final String id;

    public Merit toDomain() {
        return Merit.builder()
                .code(id)
                .department(department)
                .build();
    }


    public static MemberVeteranVO fromDomain(Merit merit) {
        return new MemberVeteranVO(merit.getDepartment(), merit.getCode());
    }
}
