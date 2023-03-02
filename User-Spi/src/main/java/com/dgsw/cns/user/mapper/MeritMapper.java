package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.Merit;
import com.dgsw.cns.user.domain.MeritEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MeritMapper implements Mapper<Merit, MeritEntity> {

    @Override
    public MeritEntity domainToEntity(Merit domain) {
        return MeritEntity.builder()
                .meritCode(domain.getCode())
                .department(domain.getDepartment())
                .build();
    }

    @Override
    public Merit entityToEntity(MeritEntity entity) {
        return Merit.builder()
                .code(entity.getMeritCode())
                .department(entity.getDepartment())
                .build();
    }
}
