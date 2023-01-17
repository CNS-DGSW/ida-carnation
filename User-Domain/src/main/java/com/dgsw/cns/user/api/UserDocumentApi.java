package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberDocumentVO;

/**
 * 유저(지원생)의 자소서와 학업게획서를 조회 및 작성하는 API 인터페이스
 */
public interface UserDocumentApi {

    /**
     * 지원생이 작성한 자소서와 학업 계획서를 조회한다.
     * @param id 지원생 식별키(PK)
     * @return 작성된 자소서 및 학업 계획서
     */
    MemberDocumentVO getDocuments(Long id);

    /**
     * 자소서와 학업 계획서를 작성하고 저장합니다.
     * @param memberDocumentVO 자소서 및 학업 계획서
     */
    void writeDocuments(MemberDocumentVO memberDocumentVO);

}
