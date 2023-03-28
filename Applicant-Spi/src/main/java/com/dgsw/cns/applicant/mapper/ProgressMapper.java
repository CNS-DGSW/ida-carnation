package com.dgsw.cns.applicant.mapper;

import com.dgsw.cns.applicant.domain.Progress;
import com.dgsw.cns.applicant.domain.ProgressEntity;
import com.dgsw.cns.global.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ProgressMapper implements Mapper<Progress, ProgressEntity> {

    @Override
    public ProgressEntity domainToEntity(Progress domain) {
        return ProgressEntity.builder()
                .applyType(domain.getApplyType())
                .applyDetailType(domain.getApplyDetailType())
                .isPassed(domain.getIsPassed())
                .build();
    }

    @Override
    public Progress entityToDomain(ProgressEntity entity) {
        return Progress.builder()
                .applyType(entity.getApplyType())
                .applyDetailType(entity.getApplyDetailType())
                .isPassed(entity.getIsPassed())
                .build();
    }
}
