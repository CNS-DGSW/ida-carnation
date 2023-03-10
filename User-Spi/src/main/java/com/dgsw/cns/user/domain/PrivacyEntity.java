package com.dgsw.cns.user.domain;

import com.dgsw.cns.user.domain.embedd.EmbeddedUserId;
import com.dgsw.cns.user.domain.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private EmbeddedUserId userId;

    @Column(nullable = false)
    private LocalDate birth;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 16)
    private String contact;

    @Column(length = 10)
    private String meritCode;

}
