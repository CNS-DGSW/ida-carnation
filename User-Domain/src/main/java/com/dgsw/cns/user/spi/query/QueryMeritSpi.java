package com.dgsw.cns.user.spi.query;

import com.dgsw.cns.user.domain.Merit;

import java.util.Optional;

/**
 * 주소 도메인과 직접적인 관계가 있는 쿼리들만 취급하는 POJO 형식의 DAO
 * @see com.dgsw.cns.user.domain.Merit
 */
public interface QueryMeritSpi {

    Merit saveOrUpdate(Merit merit);

    Optional<Merit> findMeritByCode(String meritCode);

}
