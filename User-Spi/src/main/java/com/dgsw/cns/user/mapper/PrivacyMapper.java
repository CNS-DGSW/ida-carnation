package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.MemberEntity;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.domain.PrivacyEntity;
import com.dgsw.cns.user.domain.embedd.EmbeddedUserId;
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
                .userId(new EmbeddedUserId(findMemberById(privacy.getUserId())))
                .birth(privacy.getBirth())
                .contact(privacy.getContact())
                .meritCode(privacy.getMeritCode())
                .gender(privacy.getGender())
                .build();
    }

    @Override
    public Privacy entityToDomain(PrivacyEntity privacyEntity) {
        return Privacy.builder()
                .userId(privacyEntity.getUserId().getMember().getId())
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
