package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.*;
import com.dgsw.cns.user.domain.embedd.EmbeddedUserId;
import com.dgsw.cns.user.domain.repository.AddressRepository;
import com.dgsw.cns.user.domain.repository.MemberRepository;
import com.dgsw.cns.user.domain.repository.ParentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPrivacyMapper implements Mapper<UserPrivacy, UserPrivacyEntity> {

    private final AddressRepository addressRepository;
    private final MemberRepository memberRepository;
    private final ParentRepository parentRepository;

    @Override
    public UserPrivacyEntity domainToEntity(UserPrivacy userPrivacy) {
        return UserPrivacyEntity.builder()
                .userId(new EmbeddedUserId(findMemberById(userPrivacy.getUserId())))
                .address(findAddressById(userPrivacy.getAddressId()))
                .parent(findParentById(userPrivacy.getParentId()))
                .build();
    }

    @Override
    public UserPrivacy entityToEntity(UserPrivacyEntity userPrivacyEntity) {
        return UserPrivacy.builder()
                .userId(userPrivacyEntity.getUserId().getMember().getId())
                .parentId(userPrivacyEntity.getParent().getId())
                .addressId(userPrivacyEntity.getAddress().getId())
                .build();
    }

    private MemberEntity findMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }

    private AddressEntity findAddressById(long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow();
    }

    private ParentEntity findParentById(long parentId) {
        return parentRepository.findById(parentId)
                .orElseThrow();
    }
}
