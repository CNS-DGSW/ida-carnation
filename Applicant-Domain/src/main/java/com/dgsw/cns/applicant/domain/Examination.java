package com.dgsw.cns.applicant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Examination {
    private final Long examCode;
    private final Integer aptitudeScore;
    private final Integer swAbilityScore;
    private final Integer codingTestScore;
    private final Integer cooperationScore;
}
