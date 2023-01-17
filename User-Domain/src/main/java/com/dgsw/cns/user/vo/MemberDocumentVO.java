package com.dgsw.cns.user.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 회원(지원자)의 자소서와 학업 게획서를 담는 Value Object class
 */
@Getter
@RequiredArgsConstructor
public class MemberDocumentVO {

    /**
     * 자소서
     */
    private final String introduce;

    /**
     * 학업 계획서
     */
    private final String plan;

}
