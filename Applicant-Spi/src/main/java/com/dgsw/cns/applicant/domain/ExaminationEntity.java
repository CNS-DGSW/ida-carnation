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
public class ExaminationEntity {
    @Id
    private Long userId;

    @MapsId
    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private ApplicantInfoEntity applicantInfo;

    @Column(unique = true)
    private Long examCode;

    private Integer aptitudeScore;
    private Integer swAbilityScore;
    private Integer codingTestScore;
    private Integer cooperationScore;

}
