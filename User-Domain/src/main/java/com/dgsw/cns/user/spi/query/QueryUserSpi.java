package com.dgsw.cns.user.spi.query;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Privacy;

import java.time.LocalDate;
import java.util.Optional;

/**
 * 회원 도메인과 직접적인 관계가 있는 쿼리들만 취급하는 POJO 형식의 DAO
 * @see Member
 */
public interface QueryUserSpi {

    boolean existsUserById(Long userId);

    boolean existsUserByEmail(String email);

    Optional<Member> findUserById(Long userId);

    Optional<Member> findUserByEmail(String email);

    Member saveUser(Member member);

    /**
     * name 필드와 Privacy 도메인에 있는 {@link Privacy#getBirth()} 를 통해 이메일 필드 조회
     * @see Privacy
     * @return email 사용자의 이메일
     */
    String findEmailByNameAndBirth(String name, LocalDate birth);
}
