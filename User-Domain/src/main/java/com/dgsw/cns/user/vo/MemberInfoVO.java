package com.dgsw.cns.user.vo;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.domain.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 회원의 개인정보(성함, 생일, 성별, 전화번호)
 */
@Getter
@RequiredArgsConstructor
public class MemberInfoVO {

    @NotBlank
    private final String name;

    @NotBlank
    @Pattern(regexp = "(\\d{4})-(\\d{2})-(\\d{2})")
    private final String birth;

    @NotBlank
    private final String gender;

    @NotBlank
    @Pattern(regexp = "010-(\\d{4})-(\\d{4})")
    private final String telephone;

    public Privacy toDomain() {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return Privacy.builder()
                .birth(LocalDate.from(formatter.parse(birth)))
                .gender(Gender.valueOf(gender.toUpperCase()))
                .contact(telephone)
                .build();
    }

    public static MemberInfoVO fromDomain(Member member, Privacy privacy) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return new MemberInfoVO(member.getName(), formatter.format(privacy.getBirth()),
                privacy.getGender().name().toUpperCase(), privacy.getContact());
    }

}
