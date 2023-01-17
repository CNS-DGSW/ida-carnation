package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberImageVO;

/**
 * 지원생의 프로필 사진을 조회 및 수정하는 API 인터페이스
 * @see MemberImageVO
 */
public interface UserProfileApi {

    /**
     * 지원생의 저장된 이미지를 조회합니다.
     * @param userId 지원생 식별키(PK)
     * @return 지원생의 증명사진 리소스를 반환합니다.
     */
    MemberImageVO getImage(Long userId);

    /**
     * 지원생의 이미지를 변경 및 저장합니다.
     * @param image 지원생의 증명사진 리소스
     */
    void setImage(MemberImageVO image);

}
