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

        queryParentSpi.saveOrUpdate(getLatestParent(userId, memberParentVO.toParentDomain()));
        queryAddressSpi.saveOrUpdate(getLatestAddress(userId, memberParentVO.toAddressDomain()));
    }

    protected Parent getLatestParent(Long userId, Parent valueObject) {
        Parent recentParent = queryParentSpi.findParentByMemberId(userId)
                .orElse(valueObject);
        return (recentParent.equals(valueObject)) ? recentParent : valueObject;
    }

    protected Address getLatestAddress(Long userId, Address valueObject) {
        Address recentAddress = queryAddressSpi.findAddressByMemberId(userId)
                .orElse(valueObject);
        return (recentAddress.equals(valueObject)) ? recentAddress : valueObject;
    }
}
