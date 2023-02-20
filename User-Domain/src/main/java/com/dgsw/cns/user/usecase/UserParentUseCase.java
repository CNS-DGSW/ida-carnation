package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserParentApi;
import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Parent;
import com.dgsw.cns.user.spi.query.QueryAddressSpi;
import com.dgsw.cns.user.spi.query.QueryParentSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.vo.MemberParentVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserParentUseCase implements UserParentApi {

    private final QueryUserSpi queryUserSpi;
    private final QueryAddressSpi queryAddressSpi;
    private final QueryParentSpi queryParentSpi;

    @Override
    public MemberParentVO getParentInfo(Long userId) {
        if (!queryUserSpi.existsUserById(userId)) {
            throw new Member.MemberNotFoundException();
        }

        Address address = queryAddressSpi.findAddressByMemberId(userId)
                .orElseThrow(Address.AddressNotFoundException::new);
        Parent parent = queryParentSpi.findParentByMemberId(userId)
                .orElseThrow(Parent.ParentNotFoundException::new);
        return MemberParentVO.fromDomain(address, parent);
    }

    @Override
    public void modifyParentInfo(Long userId, MemberParentVO memberParentVO) {
        if (!queryUserSpi.existsUserById(userId)) {
            throw new Member.MemberNotFoundException();
        }

        final Parent newParent = memberParentVO.toParentDomain();
        final Address newAddress = memberParentVO.toAddressDomain();

        // 데이터베이스에 존재한다면 조회, 없으면 VO를 사용하여 생성
        Parent parent = queryParentSpi.findParentByMemberId(userId)
                .orElse(memberParentVO.toParentDomain());
        Address address = queryAddressSpi.findAddressByMemberId(userId)
                .orElse(memberParentVO.toAddressDomain());
        if (!parent.equals(newParent)) {
            // 변경 감지
            parent = newParent;
        }
        if (!address.equals(newAddress)) {
            address = newAddress;
        }

        queryParentSpi.saveOrUpdate(parent);
        queryAddressSpi.saveOrUpdate(address);
    }
}
