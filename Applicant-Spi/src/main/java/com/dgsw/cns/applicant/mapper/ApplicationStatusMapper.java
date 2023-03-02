package com.dgsw.cns.applicant.mapper;

import com.dgsw.cns.applicant.domain.ApplicationStatus;
import com.dgsw.cns.applicant.domain.ApplicationStatusEntity;
import com.dgsw.cns.global.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStatusMapper implements Mapper<ApplicationStatus, ApplicationStatusEntity> {
    @Override
    public ApplicationStatusEntity domainToEntity(ApplicationStatus domain) {
        return ApplicationStatusEntity.builder()
                .isPostArrived(domain.getIsPostArrived())
                .isReviewing(domain.getIsReviewing())
                .submittedAt(domain.getSubmittedAt())
                .isSubmitted(domain.getIsSubmitted())
                .isSubmitCompleted(domain.getIsSubmitCompleted())
                .build();
    }

    @Override
    public ApplicationStatus entityToEntity(ApplicationStatusEntity entity) {
        return ApplicationStatus.builder()
                .isPostArrived(entity.getIsPostArrived())
                .isReviewing(entity.getIsReviewing())
                .submittedAt(entity.getSubmittedAt())
                .isSubmitted(entity.getIsSubmitted())
                .isSubmitCompleted(entity.getIsSubmitCompleted())
                .build();
    }
}
