package com.dgsw.cns.user.usecase.cetification;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.certification.UserLoginApi;
import com.dgsw.cns.user.spi.certification.UserLoginCertificationSpi;
import com.dgsw.cns.user.vo.certification.MemberLoginVO;
import com.dgsw.cns.user.vo.certification.TokenVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserLoginUseCase implements UserLoginApi {

    private final UserLoginCertificationSpi loginSpi;

    @Override
    public TokenVO userLogin(MemberLoginVO memberLoginVO) {
        return loginSpi.login(memberLoginVO.getEmail(), memberLoginVO.getPassword());
    }
}
