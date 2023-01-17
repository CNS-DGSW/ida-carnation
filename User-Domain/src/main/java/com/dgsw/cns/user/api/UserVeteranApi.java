package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberVeteranVO;

/**
 * 국가 보훈 대상자인 지원자에게 해당되는 API 인터페이스. <br>
 * 국가 보훈 번호를 통해 코드를 아이디를 조회합니다.
 */
public interface UserVeteranApi {

    MemberVeteranVO getVeteranInfo(Long userId);

    void putVeteranInfo(MemberVeteranVO memberVeteranVO);

}
