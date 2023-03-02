package com.dgsw.cns.applicant.domain;

import com.dgsw.cns.applicant.domain.types.ApplyDetailType;
import com.dgsw.cns.applicant.domain.types.ApplyType;
import com.dgsw.cns.applicant.domain.types.ProgressStep;
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
public class ProgressEntity {
    @Id
    private ApplicantProgressId id;

    private Boolean isPassed;

    @Enumerated(EnumType.STRING)
    private ApplyType applyType;

    @Enumerated(EnumType.STRING)
    private ApplyDetailType applyDetailType;

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Embeddable
    public static class ApplicantProgressId implements Serializable {
        @Serial
        private static final long serialVersionUID = -6318813839014154525L;

        @OneToOne
        @JoinColumn(referencedColumnName = "userId")
        private ApplicantInfoEntity applicantInfo;

        @Enumerated(EnumType.STRING)
        private ProgressStep step;
    }
}
