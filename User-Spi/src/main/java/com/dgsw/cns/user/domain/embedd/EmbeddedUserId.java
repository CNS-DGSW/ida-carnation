package com.dgsw.cns.user.domain.embedd;

import com.dgsw.cns.user.domain.MemberEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Embeddable
@SuperBuilder
@EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class EmbeddedUserId implements Serializable {

    @Serial
    private static final long serialVersionUID = -2320112734322523181L;

    @OneToOne
    private MemberEntity member;
}
