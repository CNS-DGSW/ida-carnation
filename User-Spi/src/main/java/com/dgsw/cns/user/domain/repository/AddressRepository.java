package com.dgsw.cns.user.domain.repository;

import com.dgsw.cns.user.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    Optional<AddressEntity> findByMemberId(Long memberId);
}
