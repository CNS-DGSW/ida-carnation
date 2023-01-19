package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.MemberEntity;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.domain.PrivacyEntity;
import com.dgsw.cns.user.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PrivacyMapper implements Mapper<Privacy, PrivacyEntity> {

    private final MemberRepository memberRepository;

    @Override
    public PrivacyEntity domainToEntity(Privacy privacy) {
        return PrivacyEntity.builder()
                .member(findMemberById(privacy.getUserId()))
                .birth(privacy.getBirth())
                .contact(privacy.getContact())
                .meritCode(privacy.getMeritCode())
                .gender(privacy.getGender())
                .build();
    }

    @Override
    public Privacy entityToEntity(PrivacyEntity privacyEntity) {
        return Privacy.builder()
                .userId(privacyEntity.getMemberId().getMemberId())
                .birth(privacyEntity.getBirth())
                .contact(privacyEntity.getContact())
                .meritCode(privacyEntity.getMeritCode())
                .gender(privacyEntity.getGender())
                .build();
    }

    private MemberEntity findMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }
}
