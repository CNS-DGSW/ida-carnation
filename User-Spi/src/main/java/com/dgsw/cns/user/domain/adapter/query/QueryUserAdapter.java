package com.dgsw.cns.user.domain.adapter.query;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.repository.MemberRepository;
import com.dgsw.cns.user.mapper.MemberMapper;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
public class QueryUserAdapter implements QueryUserSpi {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public boolean existsUserById(Long userId) {
        return memberRepository.existsById(userId);
    }

    @Override
    public boolean existsUserByEmail(String email) {
        return memberRepository.existsByEmail(email);
    }

    @Override
    public Optional<Member> findUserById(Long userId) {
        return Optional.of(memberMapper.entityToDomain(
                memberRepository.findById(userId)
                        .orElseThrow(Member.MemberNotFoundException::new)
        ));
    }

    @Override
    public Optional<Member> findUserByEmail(String email) {
        return Optional.of(memberMapper.entityToDomain(
                memberRepository.findByEmail(email)
                        .orElseThrow(Member.MemberNotFoundException::new)
        ));
    }

    @Override
    public Member saveUser(Member member) {
        return memberMapper.entityToDomain(
                memberRepository.save(
                        memberMapper.domainToEntity(member)
                ));
    }

    @Override
    public String findEmailByNameAndBirth(String name, LocalDate birth) {
        return memberRepository.findEmailByNameAndPrivacy_Birth(name, birth);
    }
}
