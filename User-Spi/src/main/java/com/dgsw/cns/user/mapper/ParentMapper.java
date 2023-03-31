package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.MemberEntity;
import com.dgsw.cns.user.domain.Parent;
import com.dgsw.cns.user.domain.ParentEntity;
import com.dgsw.cns.user.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ParentMapper implements Mapper<Parent, ParentEntity> {

    private final MemberRepository memberRepository;

    @Override
    public ParentEntity domainToEntity(Parent parent) {
        return ParentEntity.builder()
                .id(parent.getId())
                .member(findMemberById(parent.getUserId()))
                .birth(parent.getBirth())
                .contact(parent.getContact())
                .name(parent.getName())
                .relation(parent.getRelation())
                .build();
    }

    @Override
    public Parent entityToDomain(ParentEntity parentEntity) {
        return Parent.builder()
                .id(parentEntity.getId())
                .userId(parentEntity.getMember().getId())
                .birth(parentEntity.getBirth())
                .contact(parentEntity.getContact())
                .name(parentEntity.getName())
                .relation(parentEntity.getRelation())
                .build();
    }

    private MemberEntity findMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }
}
