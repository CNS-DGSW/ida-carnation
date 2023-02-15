package com.dgsw.cns.user.spi.certification.email;

/**
 * 이메일에 전송할 코드를 생성 및 저장하는 Spi
 * @param <T> 암호화를 통해 만들어낼 클래스
 */
public interface RandomCodeSpi<T> {

    /**
     * 난수 코드 생성
     * @return 암호화를 거쳐 나온 결과물
     */
    T createRandomCode();

    /**
     * 난수 코드 임시 저장
     * 임시로 저장하고, 일정시간이 지나면 자동으로 사라짐
     * @param code 전송한 난수 코드
     */
    void saveRandomCode(T code);

}
