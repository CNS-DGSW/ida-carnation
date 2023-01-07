package com.dgsw.cns.user.domain;

import com.dgsw.cns.global.domain.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Getter
@Entity
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
public class ParentEntity extends BaseIdEntity<Long> {

    @Column(nullable = false)
    private LocalDate birth;

    @Column(length = 16)
    private String contact;

    @Column(length = 64, nullable = false)
    private String name;

    @Column(length = 16, nullable = false)
    private String relation;

}
