package com.dgsw.cns.applicant.domain;

import com.dgsw.cns.applicant.domain.types.ApplyDetailType;
import com.dgsw.cns.applicant.domain.types.ApplyType;
import com.dgsw.cns.applicant.domain.types.ProgressStep;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Progress {
    private final ProgressStep step;
    private final Boolean isPassed;
    private final ApplyType applyType;
    private final ApplyDetailType applyDetailType;
}
