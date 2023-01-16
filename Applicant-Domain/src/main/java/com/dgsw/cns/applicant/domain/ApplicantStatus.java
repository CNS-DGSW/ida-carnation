package com.dgsw.cns.applicant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ApplicantStatus {
    private final Boolean isSubmitted;
    private final Boolean isPostArrived;
    private final Boolean isReviewing;
    private final LocalDateTime submittedAt;
    private final Boolean isSubmitCompleted;
}
