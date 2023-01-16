package com.dgsw.cns.applicant.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InterviewEntity {
    @Id
    private Long userId;

    @MapsId
    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private ApplicantInfoEntity applicantInfo;

    private Long assignedTeamNumber;
    private Boolean isAttended;
}
