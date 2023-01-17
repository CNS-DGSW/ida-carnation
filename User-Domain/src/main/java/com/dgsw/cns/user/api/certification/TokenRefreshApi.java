package com.dgsw.cns.user.api.certification;

import com.dgsw.cns.user.vo.certification.RefreshTokenVO;
import com.dgsw.cns.user.vo.certification.TokenVO;

/**
 * 유저의 엑세스 토큰을 재발급하는 API 인터페이스.
 * @see TokenVO
 * @see RefreshTokenVO
 */
public interface TokenRefreshApi {

    /**
     * 리프레시 토큰을 사용하여, 새로운 토큰을 발급받습니다.
     * @param refreshTokenVO 리프레시 토큰
     * @return 새로 발급된 토큰
     */
    TokenVO tokenRefresh(RefreshTokenVO refreshTokenVO);

}
