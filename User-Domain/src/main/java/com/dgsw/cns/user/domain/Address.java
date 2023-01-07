package com.dgsw.cns.user.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Address {

    private final Long id;
    private final String detailAddress;
    private final String streetAddress;
    private final short zipCode;

}
