package com.dgsw.cns.user.vo.certification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원의 아이디(이메일)을 찾기 위한 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberRecoveryIdVO {

    @NotBlank
    private final String name;

    @Pattern(regexp = "(\\d{4})-(\\d{2})-(\\d{2})")
    private final String birth;

}
