package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.AddressEntity;
import com.dgsw.cns.user.domain.MemberEntity;
import com.dgsw.cns.user.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressMapper implements Mapper<Address, AddressEntity> {

    private final MemberRepository memberRepository;

    @Override
    public AddressEntity domainToEntity(Address address) {
        return AddressEntity.builder()
                .id(address.getId())
                .member(findMemberById(address.getUserId()))
                .detailAddress(address.getDetailAddress())
                .streetAddress(address.getStreetAddress())
                .zipCode(address.getZipCode())
                .build();
    }

    @Override
    public Address entityToDomain(AddressEntity addressEntity) {
        return Address.builder()
                .id(addressEntity.getId())
                .userId(addressEntity.getMember().getId())
                .detailAddress(addressEntity.getDetailAddress())
                .streetAddress(addressEntity.getStreetAddress())
                .zipCode(addressEntity.getZipCode())
                .build();
    }

    private MemberEntity findMemberById(long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow();
    }
}
