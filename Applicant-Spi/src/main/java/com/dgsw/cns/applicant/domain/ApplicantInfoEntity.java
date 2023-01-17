package com.dgsw.cns.applicant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApplicantInfoEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 4643205639722210841L;

    @Id
    private Long userId;

    private Integer applyCode;
}
