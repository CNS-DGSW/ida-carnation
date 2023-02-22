package com.dgsw.cns.user.vo;

import com.dgsw.cns.user.domain.Merit;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    private final String department;

    /**
     * 보훈 번호 (양식: xx-xxxxxx)
     */
    @Size(min = 9, max = 9, message = "보훈번호는 '-'를 포함하여 9자리입니다.")
    @Pattern(regexp = "(\\d{2})-(\\d{6})", message = "보훈번호의 양식은 xx-xxxxxx입니다.")
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
