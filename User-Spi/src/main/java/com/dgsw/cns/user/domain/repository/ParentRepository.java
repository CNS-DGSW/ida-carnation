package com.dgsw.cns.user.domain.repository;

import com.dgsw.cns.user.domain.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
}
