package com.dgsw.cns.user.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class Parent {

    private final Long id;
    private final Long userId;          // related on Member
    private final LocalDate birth;
    private final String contact;
    private final String name;
    private final String relation;

}
