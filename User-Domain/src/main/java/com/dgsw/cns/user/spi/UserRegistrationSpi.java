package com.dgsw.cns.user.spi;

import com.dgsw.cns.user.spi.certification.PasswordCertificationSpi;
import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;

/**
 * 유저 회원가입을 진행하는 서비스 인터페이스
 * @see com.dgsw.cns.user.spi.certification.PasswordCertificationSpi
 */
public interface UserRegistrationSpi {

    /**
     * 이메일, 비밀번호, 이메일 인증 코드를 인자로 사용하여 회원가입을 진행합니다.
     * 이때, 이메일은 {@link EmailCertificationSpi#matchesVerificationCode(String)}를 통해
     * 이메일 검증을 거챠야합니다.
     * Database 에 저장할 때에는 보안을 위해
     * {@link PasswordCertificationSpi#encryptPassword(String)}
     * 를 통해 비밀번호를 반드시 암호화한 후, 저장을 해야합니다.
     * 저장할 대상(이메일)로 전송한 랜덤한 6자리(인증 코드) 역시 인증을 한 후
     * 최종적으로 회원가입이 완료됩니다.
     * <pre>
     * {@link EmailCertificationSpi#sendCertificationCode(String, Object)}
     * {@link EmailCertificationSpi#matchesVerificationCode(String)}
     * </pre>
     *
     * @param email 가입할 이메일
     * @param password 비밀번호
     * @param verificationCode 인증 코드
     */
    void register(final String email, final String password, final String verificationCode);

}
