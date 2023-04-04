package com.dgsw.cns.user.domain.adapter.query;

import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.domain.repository.PrivacyRepository;
import com.dgsw.cns.user.mapper.PrivacyMapper;
import com.dgsw.cns.user.spi.query.QueryPrivacySpi;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class QueryPrivacyAdapter implements QueryPrivacySpi {

    private final PrivacyRepository privacyRepository;
    private final PrivacyMapper privacyMapper;

    @Override
    public Privacy saveOrUpdate(Privacy privacy) {
        return privacyMapper.entityToDomain(
                privacyRepository.save(
                        privacyMapper.domainToEntity(privacy)
                ));
    }

    @Override
    public Optional<Privacy> findPrivacyByMemberId(Long memberId) {
        return Optional.of(privacyMapper.entityToDomain(
                privacyRepository.findByMemberId(memberId)
                        .orElseThrow(Privacy.PrivacyNotFoundException::new)
        ));
    }
}
