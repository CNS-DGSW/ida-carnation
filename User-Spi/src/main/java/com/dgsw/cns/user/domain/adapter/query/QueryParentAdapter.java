package com.dgsw.cns.user.domain.adapter.query;

import com.dgsw.cns.user.domain.Parent;
import com.dgsw.cns.user.domain.repository.ParentRepository;
import com.dgsw.cns.user.mapper.ParentMapper;
import com.dgsw.cns.user.spi.query.QueryParentSpi;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class QueryParentAdapter implements QueryParentSpi {

    private final ParentMapper parentMapper;

    private final ParentRepository parentRepository;
    @Override
    public Parent saveOrUpdate(Parent parent) {
        return parentMapper.entityToDomain(parentRepository.save(
                parentMapper.domainToEntity(parent)
                ));
    }

    @Override
    public Optional<Parent> findParentByMemberId(Long memberId) {
        return Optional.of(parentMapper.entityToDomain(
                parentRepository.findByMemberId(memberId)
                        .orElseThrow(Parent.ParentNotFoundException::new)
        ));
    }
}
