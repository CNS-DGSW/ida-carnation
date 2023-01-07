package com.dgsw.cns.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserPrivacy {

    private final Long userId;
    private Long addressId;
    private Long parentId;

}
