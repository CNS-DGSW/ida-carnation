package com.dgsw.cns.user.domain.repository;

import com.dgsw.cns.user.domain.MeritEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeritRepository extends JpaRepository<MeritEntity, String> {
}
