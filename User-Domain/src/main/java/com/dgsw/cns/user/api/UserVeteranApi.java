package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberVeteranVO;

/**
 * 국가 보훈 대상자인 지원생에게 해당되는 API 인터페이스. <br>
 * 국가 보훈 번호를 통해 코드를 아이디를 조회합니다.
 * @see MemberVeteranVO
 */
public interface UserVeteranApi {

    /**
     * 지원생에게 저장된 국가 보훈 정보를 조회합니다.
     * @param userId 지원생 식별키(PK)
     * @return 국가 보훈 정보를 반환합니다.
     */
    MemberVeteranVO getVeteranInfo(Long userId);

    /**
     * 지원생에게 국가 보훈 번호와 보훈처를 작성합니다. <br>
     * 국가 보훈 번호는 반드시 양식에 맞게 작성되어야합니다.
     * @param memberVeteranVO 국가 보훈 번호와 보훈처
     */
    void putVeteranInfo(MemberVeteranVO memberVeteranVO);

}
