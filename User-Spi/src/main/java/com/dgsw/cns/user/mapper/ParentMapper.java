package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.Parent;
import com.dgsw.cns.user.domain.ParentEntity;
import org.springframework.stereotype.Component;

@Component
public class ParentMapper implements Mapper<Parent, ParentEntity> {

    @Override
    public ParentEntity domainToEntity(Parent parent) {
        return ParentEntity.builder()
                .id(parent.getId())
                .birth(parent.getBirth())
                .contact(parent.getContact())
                .name(parent.getName())
                .relation(parent.getRelation())
                .build();
    }

    @Override
    public Parent entityToEntity(ParentEntity parentEntity) {
        return Parent.builder()
                .id(parentEntity.getId())
                .birth(parentEntity.getBirth())
                .contact(parentEntity.getContact())
                .name(parentEntity.getName())
                .relation(parentEntity.getRelation())
                .build();
    }
}
