package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserVeteranApi;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Merit;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.spi.query.QueryMeritSpi;
import com.dgsw.cns.user.spi.query.QueryPrivacySpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.vo.MemberVeteranVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserVeteranUseCase implements UserVeteranApi {

    private final QueryUserSpi queryUserSpi;
    private final QueryPrivacySpi queryPrivacySpi;
    private final QueryMeritSpi queryMeritSpi;

    @Override
    public MemberVeteranVO getVeteranInfo(Long userId) {
        if (!queryUserSpi.existsUserById(userId)) {
            throw new Member.MemberNotFoundException();
        }

        final Privacy privacy = queryPrivacySpi.findPrivacyByMemberId(userId)
                .orElseThrow(Privacy.PrivacyNotFoundException::new);
        final Merit merit = queryMeritSpi.findMeritByCode(privacy.getMeritCode())
                .orElseThrow(Merit.ForgeryMeritCodeException::new);
        return MemberVeteranVO.fromDomain(merit);
    }

    @Override
    public void putVeteranInfo(Long userId, MemberVeteranVO memberVeteranVO) {
        if (!queryUserSpi.existsUserById(userId)) {
            throw new Member.MemberNotFoundException();
        }

        final Privacy privacy = queryPrivacySpi.findPrivacyByMemberId(userId)
                .orElseThrow(Privacy.PrivacyNotFoundException::new);
        final Merit latestMerit = getLatestMerit(privacy, memberVeteranVO.toDomain());

        privacy.updateMeritCode(latestMerit.getCode());
        queryMeritSpi.saveOrUpdate(latestMerit);
        queryPrivacySpi.saveOrUpdate(privacy);
    }

    protected Merit getLatestMerit(Privacy privacy, Merit valueObject) {
        if (privacy.isCodeNull()) {
            return valueObject;
        }

        Merit recentMerit = queryMeritSpi.findMeritByCode(privacy.getMeritCode())
                .orElseThrow(Merit.ForgeryMeritCodeException::new);
        return (recentMerit.equals(valueObject)) ? recentMerit : valueObject;
    }
}
