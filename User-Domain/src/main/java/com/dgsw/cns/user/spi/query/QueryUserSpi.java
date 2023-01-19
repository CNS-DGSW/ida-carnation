package com.dgsw.cns.user.spi.query;

import com.dgsw.cns.user.domain.Member;

import java.util.Optional;

/**
 * 회원 도메인과 직접적인 관계가 있는 쿼리들만 취급하는 POJO 형식의 DAO
 * @see Member
 */
public interface QueryUserSpi {

    boolean existsUserById(Long userId);

    boolean existsUserByEmail(String email);

    Optional<Member> findUserById(Long userId);

    Member saveUser(Member member);

}
