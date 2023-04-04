package com.dgsw.cns.user.domain.repository;

import com.dgsw.cns.user.domain.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
    Optional<ParentEntity> findByMemberId(Long memberId);
}
