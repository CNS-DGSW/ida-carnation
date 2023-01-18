package com.dgsw.cns.user.spi.certification;

/**
 * 비밀번호 암화 및 유효성 검증 서비스 인터페이스
 */
public interface PasswordCertificationSpi {

    /**
     * 비밀번호의 유효성을 검증합니다.
     * @param rawPassword 입력받은, 암호되지 않은 비밀번호
     * @param encodedPassword 암호환된 비밀번호
     * @return 비밀번호가 유효한지를 반환합니다.
     */
    boolean checkValidation(final String rawPassword, final String encodedPassword);

    /**
     * 비밀번호를 암호화합니다.
     * @param rawPassword 암호화되지 않은 비밀번호
     * @return 암호환 비밀번호
     */
    String encryptPassword(final String rawPassword);

}
