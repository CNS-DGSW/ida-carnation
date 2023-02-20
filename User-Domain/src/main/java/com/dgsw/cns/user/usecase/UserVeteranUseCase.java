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

        final Merit newMerit = memberVeteranVO.toDomain();
        final Privacy privacy = queryPrivacySpi.findPrivacyByMemberId(userId)
                .orElseThrow(Privacy.PrivacyNotFoundException::new);
        // privacy 없이는 보훈 번호를 입력할 수 없다.

        Merit merit;
        if (privacy.getMeritCode() == null) {
            // 보훈 번호가 입력된 적 없는 경우, 새로운 보훈 번호로 대입
            merit = newMerit;
        }
        else {
            // 보훈번호가 데이터베이스에 저장되어있던 경우 직접 조회. 존재하지 않는다면 가짜 보훈번호로 간주
            merit = queryMeritSpi.findMeritByCode(privacy.getMeritCode())
                    .orElseThrow(Merit.ForgeryMeritCodeException::new);
            // 변경 감지
            if (!merit.equals(newMerit)) {
                // 서로 다르다면 새로운 보훈 번호로 대입
                merit = newMerit;
            }
        }

        privacy.updateMeritCode(merit.getCode());
        queryMeritSpi.saveOrUpdate(merit);
        queryPrivacySpi.saveOrUpdate(privacy);
    }
}
