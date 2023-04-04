package com.dgsw.cns.user.domain.adapter.query;

import com.dgsw.cns.user.domain.Merit;
import com.dgsw.cns.user.domain.repository.MeritRepository;
import com.dgsw.cns.user.mapper.MeritMapper;
import com.dgsw.cns.user.spi.query.QueryMeritSpi;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class QueryMeritAdapter implements QueryMeritSpi {

    private final MeritRepository meritRepository;
    private final MeritMapper meritMapper;

    @Override
    public Merit saveOrUpdate(Merit merit) {
        return meritMapper.entityToDomain(meritRepository.save(
                        meritMapper.domainToEntity(merit)
                ));
    }

    @Override
    public Optional<Merit> findMeritByCode(String meritCode) {
        return Optional.of(meritMapper.entityToDomain(
                meritRepository.findByMeritCode(meritCode)
                        .orElseThrow(Merit.ForgeryMeritCodeException::new)
        ));
    }
}
