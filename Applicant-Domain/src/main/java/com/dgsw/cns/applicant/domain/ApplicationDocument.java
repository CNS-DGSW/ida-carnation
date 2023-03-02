package com.dgsw.cns.applicant.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ApplicationDocument {
    private final String introduction;
    private final String plan;
    private final String picture;
}
