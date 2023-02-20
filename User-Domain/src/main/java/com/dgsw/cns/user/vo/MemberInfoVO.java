package com.dgsw.cns.user.vo;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.domain.enums.Gender;
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

    private final String name;

    private final String birth;

    private final String gender;

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
