package com.dgsw.cns.user.api.certification;

import com.dgsw.cns.user.vo.certification.RefreshTokenVO;
import com.dgsw.cns.user.vo.certification.TokenVO;

/**
 * 유저의 엑세스 토큰을 재발급하는 API 인터페이스.
 * @see TokenVO
 * @see RefreshTokenVO
 */
public interface TokenRefreshApi {

    TokenVO tokenRefresh(RefreshTokenVO refreshTokenVO);

}
