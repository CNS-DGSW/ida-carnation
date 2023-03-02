package com.dgsw.cns.applicant.domain.repository;

import com.dgsw.cns.applicant.domain.InterviewFactorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InterviewFactorRepository extends JpaRepository<InterviewFactorEntity, Long> {
    List<InterviewFactorEntity> findAllByUserIdOrderByFactorNumberAsc(Long userId);
}
