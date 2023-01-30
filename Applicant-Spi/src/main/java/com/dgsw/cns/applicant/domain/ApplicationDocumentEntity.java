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
public class ApplicationDocumentEntity {
    @Id
    private Long userId;

    @MapsId
    @OneToOne
    @JoinColumn(referencedColumnName = "userId")
    private ApplicantInfoEntity applicantInfo;

    @Column(columnDefinition = "TEXT")
    private String introduction;

    @Column(columnDefinition = "TEXT")
    private String plan;

    private String picture;
}
