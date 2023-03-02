package com.dgsw.cns.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MeritEntity {

    @Id
    @Column(name = "merit_code", length = 10)
    private String meritCode;

    @Column(nullable = false, length = 72)
    private String department;

}
