package com.dgsw.cns.user.domain;

import com.dgsw.cns.global.domain.BaseIdEntity;
import com.dgsw.cns.user.domain.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Member 테이블의 정보들을 객체화한 Entity 클래스
 * @see com.dgsw.cns.global.domain.BaseIdEntity
 * @see Member
 */
@Getter
@Entity
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
@Table(indexes = @Index(name = "idx_email", columnList = "email"))
public class MemberEntity extends BaseIdEntity<Long> {

    @Column(nullable = false)
    private String email;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.STUDENT;

}
