package com.dgsw.cns.applicant.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApplicationStatusEntity {
    @Id
    private Long userId;

    @MapsId
    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private ApplicantInfoEntity applicantInfo;

    private Boolean isSubmitted;
    private Boolean isPostArrived;
    private Boolean isReviewing;
    private LocalDateTime submittedAt;
    private Boolean isSubmitCompleted;
}
