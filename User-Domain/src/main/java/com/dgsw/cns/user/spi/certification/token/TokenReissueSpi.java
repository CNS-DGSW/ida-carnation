package com.dgsw.cns.user.spi.certification.token;

import com.dgsw.cns.user.vo.certification.TokenVO;

/**
 * 엑세스 토큰이 만료된 상태에서 리프레시 토큰을 사용하여,
 *  토큰들을 재발급받도록 합니다.
 */
public interface TokenReissueSpi {

    /**
     * JWT 리프레쉬 토큰의 body 와 header 등을 파싱하여, 
     * 얻은 회원의 식별키(PK)의 데이터 유효성 확인,
     * 존재하는 경우, 새로운 JWT 토큰들을 반환하도록 합니다.
     * 이때, 이미 존재하던 리프레시 토큰의 유효 기간은 매우 길기에 사라지도록 유도합니다.
     * @param refreshToken JWT 리프레시 토큰
     * @return 새로운 엑세스 토큰 및 리프레시 토큰을 반환힙니다.
     */
    TokenVO reissueToken(final String refreshToken);

}
