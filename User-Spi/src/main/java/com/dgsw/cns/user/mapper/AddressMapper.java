package com.dgsw.cns.user.mapper;

import com.dgsw.cns.global.mapper.Mapper;
import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements Mapper<Address, AddressEntity> {

    @Override
    public AddressEntity domainToEntity(Address address) {
        return AddressEntity.builder()
                .id(address.getId())
                .detailAddress(address.getDetailAddress())
                .streetAddress(address.getStreetAddress())
                .zipCode(address.getZipCode())
                .build();
    }

    @Override
    public Address entityToDomain(AddressEntity addressEntity) {
        return Address.builder()
                .id(addressEntity.getId())
                .detailAddress(addressEntity.getDetailAddress())
                .streetAddress(addressEntity.getStreetAddress())
                .zipCode(addressEntity.getZipCode())
                .build();
    }
}
