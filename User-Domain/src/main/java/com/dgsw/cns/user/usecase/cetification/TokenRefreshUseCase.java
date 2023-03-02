package com.dgsw.cns.user.usecase.cetification;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.certification.TokenRefreshApi;
import com.dgsw.cns.user.spi.certification.token.TokenReissueSpi;
import com.dgsw.cns.user.vo.certification.RefreshTokenVO;
import com.dgsw.cns.user.vo.certification.TokenVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class TokenRefreshUseCase implements TokenRefreshApi {

    private final TokenReissueSpi tokenReissueSpi;

    @Override
    public TokenVO tokenRefresh(RefreshTokenVO refreshTokenVO) {
        return tokenReissueSpi.reissueToken(refreshTokenVO.getRefreshToken());
    }
}
