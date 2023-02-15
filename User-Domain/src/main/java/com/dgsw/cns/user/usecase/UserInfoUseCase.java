package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserInfoApi;
import com.dgsw.cns.user.spi.UserInfoSpi;
import com.dgsw.cns.user.vo.MemberInfoVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserInfoUseCase implements UserInfoApi {

    private final UserInfoSpi userInfoSpi;

    @Override
    public MemberInfoVO getUserInfo(Long memberId) {
        return userInfoSpi.findUserInfo(memberId);
    }
}
