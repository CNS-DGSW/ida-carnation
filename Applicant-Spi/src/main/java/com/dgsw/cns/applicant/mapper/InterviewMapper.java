package com.dgsw.cns.applicant.mapper;

import com.dgsw.cns.applicant.domain.Interview;
import com.dgsw.cns.applicant.domain.InterviewEntity;
import com.dgsw.cns.applicant.domain.InterviewFactorEntity;
import com.dgsw.cns.applicant.domain.repository.InterviewFactorRepository;
import com.dgsw.cns.global.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class InterviewMapper implements Mapper<Interview, InterviewEntity> {
    private final InterviewFactorRepository interviewFactorRepository;

    @Override
    public InterviewEntity domainToEntity(Interview domain) {
        return InterviewEntity.builder()
                .assignedTeam(domain.getAssignedTeam())
                .isAttended(domain.getIsAttended())
                .build();
    }

    @Override
    public Interview entityToEntity(InterviewEntity entity) {
        List<Integer> factors = interviewFactorRepository
                .findAllByUserIdOrderByFactorNumberAsc(entity.getUserId())
                .stream().map(InterviewFactorEntity::getScore)
                .toList();

        return Interview.builder()
                .assignedTeam(entity.getAssignedTeam())
                .isAttended(entity.getIsAttended())
                .scoreOfFactors(factors.toArray(new Integer[0]))
                .build();
    }
}
