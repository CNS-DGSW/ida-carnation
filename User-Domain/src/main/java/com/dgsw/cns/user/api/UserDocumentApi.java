package com.dgsw.cns.user.api;

import com.dgsw.cns.user.vo.MemberDocumentVO;

/**
 * 유저(지원생)의 자소서와 학업게획서를 조회 및 작성하는 API 인터페이스
 */
public interface UserDocumentApi {

    MemberDocumentVO getDocuments(Long id);

    void writeDocuments(MemberDocumentVO memberDocumentVO);

}
