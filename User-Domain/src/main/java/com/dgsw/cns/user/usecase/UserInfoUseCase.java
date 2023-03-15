package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserInfoApi;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.spi.query.QueryPrivacySpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.vo.MemberInfoVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserInfoUseCase implements UserInfoApi {

    private final QueryUserSpi queryUserSpi;
    private final QueryPrivacySpi queryPrivacySpi;

    @Override
    public MemberInfoVO getUserInfo(Long memberId) {
        Member member = queryUserSpi.findUserById(memberId)
                .orElseThrow(Member.MemberNotFoundException::new);
        Privacy privacy = queryPrivacySpi.findPrivacyByMemberId(memberId)
                .orElseThrow(Member.MemberNotFoundException::new);
        return MemberInfoVO.fromDomain(member, privacy);
    }
}
