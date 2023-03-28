package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper implements Mapper<Member, MemberEntity> {

    @Override
    public MemberEntity domainToEntity(Member member) {
        return MemberEntity.builder()
                .id(member.getId())
                .email(member.getEmail())
                .name(member.getName())
                .password(member.getPassword())
                .role(member.getRole())
                .build();
    }

    @Override
    public Member entityToDomain(MemberEntity memberEntity) {
        return Member.builder()
                .id(memberEntity.getId())
                .email(memberEntity.getEmail())
                .name(memberEntity.getName())
                .password(memberEntity.getPassword())
                .role(memberEntity.getRole())
                .build();
    }
}
