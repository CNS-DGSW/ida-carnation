package com.dgsw.cns.user.domain.adapter.query;

import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.repository.AddressRepository;
import com.dgsw.cns.user.mapper.AddressMapper;
import com.dgsw.cns.user.spi.query.QueryAddressSpi;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class QueryAddressAdapter implements QueryAddressSpi {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;
    @Override
    public Address saveOrUpdate(Address address) {
        return addressMapper.entityToDomain(addressRepository.save(
                        addressMapper.domainToEntity(address)
                ));
    }

    @Override
    public Optional<Address> findAddressByMemberId(Long memberId) {
        return Optional.of(addressMapper.entityToDomain(
                addressRepository.findByMemberId(memberId)
                        .orElseThrow(Address.AddressNotFoundException::new)
        ));
    }
}
