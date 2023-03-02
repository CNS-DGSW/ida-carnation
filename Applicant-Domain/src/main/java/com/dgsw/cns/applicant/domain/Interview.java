package com.dgsw.cns.applicant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Interview {
    private final Integer assignedTeam;
    private final Boolean isAttended;
    private final Integer[] scoreOfFactors;
}
