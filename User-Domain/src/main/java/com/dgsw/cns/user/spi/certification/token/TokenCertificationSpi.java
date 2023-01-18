package com.dgsw.cns.user.spi.certification.token;

/**
 * JWT 토큰의 유효성을 검증합니다.
 */
public interface TokenCertificationSpi {

    /**
     * JWT 토큰의 서명을 검증합니다.
     * @param jwtToken JWT 토큰
     * @return 서명이 일치하다면, true. 아니라면, false 를 반환합니다.
     */
    boolean certificateToken(final String jwtToken);

    /**
     * JWT 토큰을 파싱하여, subject 를 찾습니다.
     * @param jwtToken JWT 토큰
     * @return 찾은 subject 를 반환합니다.
     */
    String extractToken(final String jwtToken);

}
