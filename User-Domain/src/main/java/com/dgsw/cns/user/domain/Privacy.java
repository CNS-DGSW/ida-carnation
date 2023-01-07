package com.dgsw.cns.user.domain;

import com.dgsw.cns.user.domain.enums.Gender;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class Privacy {

    private final Long userId;

    private final LocalDate birth;

    private final Gender gender;

    private final String contact;

    private final String meritCode;

}
