package com.dgsw.cns.user.domain;

import com.dgsw.cns.global.domain.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Entity
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressEntity extends BaseIdEntity<Long> {

    @Column(nullable = false)
    private String detailAddress;

    @Column(length = 80, nullable = false)
    private String streetAddress;

    @Column(nullable = false)
    private short zipCode;

}
