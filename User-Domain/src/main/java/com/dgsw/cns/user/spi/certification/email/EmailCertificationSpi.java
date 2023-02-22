package com.dgsw.cns.user.spi.certification.email;

/**
 * 이메일 인증 코드 발송 및 검증 서비스 인터페이스
 */
public interface EmailCertificationSpi {

    /**
     * 받은 이메일 인증코드(6자리)가 전송한 인증코드와 일치 하는 지를 확인 
     * @param code 클라이언트 측 이메일 인증코드
     * @return 일치하다면 true, 아니라면 false
     */
    boolean matches(final String code);

    /**
     * 이메일로 인증코드(6자리)를 전송합니다.
     * @param email 코드를 전달할 이메일
     * @param code 난수 인증 코드
     */
    void sendCertificationCode(final String email, Object code);

}
