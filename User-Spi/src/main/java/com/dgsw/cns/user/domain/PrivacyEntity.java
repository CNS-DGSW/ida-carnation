package com.dgsw.cns.user.domain;

import com.dgsw.cns.user.domain.embedded.EmbeddedUserId;
import com.dgsw.cns.user.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Privacy 테이블의 정보들을 객체화한 Entity 클래스
 * @see Privacy
 */
@Getter
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
public class PrivacyEntity {

    @EmbeddedId
    private EmbeddedUserId memberId;

    @OneToOne
    @MapsId("member_id")
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private MemberEntity member;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 16)
    private String contact;

    @OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name = "merit_code")
    private MeritEntity meritEntity;

}
