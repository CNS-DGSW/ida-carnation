package com.dgsw.cns.user.spi.certification.token;

import java.security.Key;
import java.util.Optional;

/**
 * JWT 토큰을 생성하고, HTTP 헤더로부터 파싱하는 서비스 인터페이스
 * @see TokenCertificationSpi
 * @see TokenReissueSpi
 */
public interface TokenSpi extends TokenReissueSpi, TokenCertificationSpi {

    /**
     * JWT 토큰을 발급합니다.
     * @param type JWT 종류(엑세스/리프레시)
     * @param id JWT subject
     * @param expireSecond JWT 만료 일자
     * @return type 종류의 JWT 토큰을 생성하여, 반환합니다.
     */
    String generateToken(final String type, final String id, final long expireSecond);

    /**
     * JWT 에 사용할 서명입니다.
     * <pre>
     * {@code signWith(key, algorithm)}
     * </pre>
     * @param type JWT 종류(엑세스/리프레시)
     * @return type 종류의 JWT 토큰에 사용할 서명을 반환합니다.
     */
    Key generateKey(final String type);

    /**
     * HTTP Header 의 특정 부분을 받아와 해당 부분에 JWT 토큰을 찾습니다.
     * 만일 UncheckedException 이 발생한 경우, 그대로 예외를 전달하고 <br>
     * CheckedException 이 발생한 경우, {@link Optional#ofNullable(Object)} 를
     * 사용하여 반환한다.
     * @param header HTTP Header 의 일부분
     * @return 찾은 헤더값에 있는 JWT 토큰 반환
     */
    Optional<String> getTokenFromHeader(String header);

}
