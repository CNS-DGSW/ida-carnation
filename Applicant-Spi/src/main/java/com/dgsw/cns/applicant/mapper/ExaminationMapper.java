package com.dgsw.cns.applicant.mapper;

import com.dgsw.cns.applicant.domain.Examination;
import com.dgsw.cns.applicant.domain.ExaminationEntity;
import com.dgsw.cns.global.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ExaminationMapper implements Mapper<Examination, ExaminationEntity> {
    @Override
    public ExaminationEntity domainToEntity(Examination domain) {
        return ExaminationEntity.builder()
                .aptitudeScore(domain.getAptitudeScore())
                .codingTestScore(domain.getCodingTestScore())
                .cooperationScore(domain.getCooperationScore())
                .swAbilityScore(domain.getSwAbilityScore())
                .build();
    }

    @Override
    public Examination entityToEntity(ExaminationEntity entity) {
        return Examination.builder()
                .aptitudeScore(entity.getAptitudeScore())
                .codingTestScore(entity.getCodingTestScore())
                .cooperationScore(entity.getCooperationScore())
                .swAbilityScore(entity.getSwAbilityScore())
                .build();
    }
}
