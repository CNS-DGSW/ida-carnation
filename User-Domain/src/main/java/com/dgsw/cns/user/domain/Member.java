package com.dgsw.cns.user.domain;

import com.dgsw.cns.user.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {

    private final Long id;
    private final String email;
    private final String name;
    private final String password;
    private final Role role;

}
