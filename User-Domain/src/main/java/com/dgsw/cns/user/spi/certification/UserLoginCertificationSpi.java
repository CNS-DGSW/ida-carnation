package com.dgsw.cns.user.spi.certification;

import com.dgsw.cns.user.vo.certification.TokenVO;

/**
 * 회원의 정보를 확인 후, 로그인을 진행하는 서비스 인터페이스
 * @see com.dgsw.cns.user.api.certification.UserLoginApi
 * @see PasswordCertificationSpi
 */
public interface UserLoginCertificationSpi extends PasswordCertificationSpi {

    /**
     * 로그인을 진행하기 위한 이메일과 비밀번호를 받아
     * 회원의 유효성 확인 및 {@link #checkValidation(String, String)} 를 사용하여 비밀번호의
     * 유효성을 확인한 후, JWT 토큰을 반환합니다.
     * @param email 회원의 이메일
     * @param rawPassword 회원의 암호화되지 않은 비밀번호
     * @return 액세스, 리프레시 JWT 토큰을 반환합니다.
     * @see TokenVO
     */
    TokenVO login(final String email, final String rawPassword);

}
