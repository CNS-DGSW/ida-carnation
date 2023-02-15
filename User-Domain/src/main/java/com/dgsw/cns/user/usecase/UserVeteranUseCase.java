package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserVeteranApi;
import com.dgsw.cns.user.spi.UserVeteranSpi;
import com.dgsw.cns.user.vo.MemberVeteranVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserVeteranUseCase implements UserVeteranApi {

    private final UserVeteranSpi userVeteranSpi;

    @Override
    public MemberVeteranVO getVeteranInfo(Long userId) {
        return userVeteranSpi.getVeteranInfo(userId);
    }

    @Override
    public void putVeteranInfo(Long userId, MemberVeteranVO memberVeteranVO) {
        userVeteranSpi.updateVeteranInfo(
                userId,
                memberVeteranVO.getDepartment(),
                memberVeteranVO.getId()
        );
    }
}
