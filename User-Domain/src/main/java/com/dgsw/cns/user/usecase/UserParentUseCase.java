package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserParentApi;
import com.dgsw.cns.user.spi.UserParentSpi;
import com.dgsw.cns.user.vo.MemberParentVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserParentUseCase implements UserParentApi {

    private final UserParentSpi userParentSpi;

    @Override
    public MemberParentVO getParentInfo(Long userId) {
        return userParentSpi.findParentInfoById(userId);
    }

    @Override
    public void modifyParentInfo(Long userId, MemberParentVO memberParentVO) {
        userParentSpi.modifyParentInfo(
                userId,
                memberParentVO.toParentDomain(),
                memberParentVO.toAddressDomain()
        );
    }
}
