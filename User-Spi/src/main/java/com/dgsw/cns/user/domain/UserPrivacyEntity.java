package com.dgsw.cns.user.domain;

import com.dgsw.cns.user.domain.embedd.EmbeddedUserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
