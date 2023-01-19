package com.dgsw.cns.user.spi.query;

import com.dgsw.cns.user.domain.Parent;

import java.util.Optional;

/**
 * 부모 도메인과 직접적인 관계가 있는 쿼리들만 취급하는 POJO 형식의 DAO
 * @see Parent
 */
public interface QueryParentSpi {

    Parent saveOrUpdate(Parent parent);

    Optional<Parent> findParentByMemberId(Long memberId);

}
