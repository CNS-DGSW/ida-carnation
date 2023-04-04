package com.dgsw.cns.user.domain.repository;

import com.dgsw.cns.user.domain.PrivacyEntity;
import com.dgsw.cns.user.domain.embedded.EmbeddedUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrivacyRepository extends JpaRepository<PrivacyEntity, EmbeddedUserId> {
    Optional<PrivacyEntity> findByMemberId(Long memberId);
}
