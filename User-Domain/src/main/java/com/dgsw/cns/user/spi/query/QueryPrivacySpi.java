package com.dgsw.cns.user.spi.query;

import com.dgsw.cns.user.domain.Privacy;

import java.util.Optional;

/**
 * 회원 개인정보 도메인과 직접적인 관계가 있는 쿼리들만 취급하는 POJO 형식의 DAO
 * @see com.dgsw.cns.user.domain.Privacy
 */
public interface QueryPrivacySpi {

    Privacy saveOrUpdate(Privacy privacy);

    Optional<Privacy> findPrivacyByMemberId(Long memberId);
}
