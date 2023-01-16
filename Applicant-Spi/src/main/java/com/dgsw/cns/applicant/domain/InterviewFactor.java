package com.dgsw.cns.applicant.domain;

import jakarta.persistence.*;
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
public class InterviewFactor {
    @Id
    private InterviewFactorId id;

    private Integer score;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class InterviewFactorId implements Serializable {
        @Serial
        private static final long serialVersionUID = 5249963166125078136L;
        @OneToOne
        @JoinColumn(referencedColumnName = "userId")
        private ApplicantInfoEntity applicantInfo;

        private Integer factorNumber;
    }
}
