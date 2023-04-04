package com.dgsw.cns.user.domain.repository;

import com.dgsw.cns.user.domain.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    boolean existsByEmail(String email);

    Optional<MemberEntity> findByEmail(String email);

    String findEmailByNameAndPrivacy_Birth(String name, LocalDate birth);
}
