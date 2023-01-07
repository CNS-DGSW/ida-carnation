package com.dgsw.cns.user.domain;

import com.dgsw.cns.user.domain.embedd.EmbeddedUserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * UserPrivacyEntity 테이블의 정보들을 객체화한 Entity 클래스
 * @see UserPrivacy
 */
@Getter
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class UserPrivacyEntity {

    @EmbeddedId
    private EmbeddedUserId userId;

    @OneToOne
    private ParentEntity parent;

    @OneToOne
    private AddressEntity address;

}
