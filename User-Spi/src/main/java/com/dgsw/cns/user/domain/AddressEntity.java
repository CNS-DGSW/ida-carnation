package com.dgsw.cns.user.domain;

import com.dgsw.cns.global.domain.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Address 테이블의 정보들을 객체화한 Entity 클래스
 * @see BaseIdEntity
 * @see Address
 */
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

    @OneToOne
    private MemberEntity member;

}
