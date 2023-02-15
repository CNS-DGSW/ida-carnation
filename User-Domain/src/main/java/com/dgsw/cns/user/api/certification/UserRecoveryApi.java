package com.dgsw.cns.user.api.certification;

import com.dgsw.cns.user.vo.certification.MemberRecoveryEmailVO;
import com.dgsw.cns.user.vo.certification.MemberRecoveryIdVO;
import com.dgsw.cns.user.vo.certification.MemberRecoveryPasswordVO;

/**
 * 아이디 찾기, 비밀번호 재설정 등과 같은 로그인을 진행하기 어려운 상황의 경우,
 * 사용하기 위한 API 인터페이스
 */
public interface UserRecoveryApi {

    /**
     * 회원의 이름과 생일을 토대로 회원의 아이디(이메일)를 반환
     * @param memberRecoveryIdVO 회원 이름과 생일
     * @return 회원의 아이디(이메일)를 반환합니다.
     */
    MemberRecoveryEmailVO findIdByName(MemberRecoveryIdVO memberRecoveryIdVO);

    /**
     * 회원의 비밀번호를 재설정합니다.
     * @param memberRecoveryPasswordVO 회원의 새로운 비밀번호
     */
    void resetPassword(MemberRecoveryPasswordVO memberRecoveryPasswordVO);

    /**
     * 회원 이메일로 난수 코드를 전송합니다.
     * @param email 회원 이메일
     */
    void sendVerificationCode(String email);

}
