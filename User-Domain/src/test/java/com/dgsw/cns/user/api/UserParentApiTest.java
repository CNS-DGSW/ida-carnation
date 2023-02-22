package com.dgsw.cns.user.api;

import com.dgsw.cns.user.domain.Address;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Parent;
import com.dgsw.cns.user.spi.query.QueryAddressSpi;
import com.dgsw.cns.user.spi.query.QueryParentSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.usecase.UserParentUseCase;
import com.dgsw.cns.user.vo.MemberParentVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserParentApiTest {

    @Mock
    private QueryUserSpi queryUserSpi;

    @Mock
    private QueryAddressSpi queryAddressSpi;

    @Mock
    private QueryParentSpi queryParentSpi;

    @InjectMocks
    private UserParentUseCase parentUseCase;

    @Test
    @DisplayName("회원가입되지 않은 케이스")
    void cannotFoundUserTest() {
        // given
        given(queryUserSpi.existsUserById(anyLong()))
                .willThrow(Member.MemberNotFoundException.class);

        // when
        ThrowingCallable method = () -> parentUseCase.getParentInfo(anyLong());

        // then
        assertThatThrownBy(method).isInstanceOf(Member.MemberNotFoundException.class);
    }
    Address dummyAddress() {
        return dummyAddress("좁은 길", "00-00", (short) 0);
    }

    Address dummyAddress(String address, String detail, short code) {
        return Address.builder()
                .streetAddress(address)
                .detailAddress(detail)
                .zipCode(code)
                .build();
    }

    Parent dummyParent(String name, String relation, String contact) {
        return dummyParent(name, relation, LocalDate.now(), contact);
    }

    Parent dummyParent(String name, String relation, LocalDate birth, String contact) {
        return Parent.builder()
                .name(name)
                .relation(relation)
                .birth(birth)
                .contact(contact)
                .build();
    }

    @Test
    @DisplayName("유저가 주소 정보를 기입하지 않은 케이스")
    void cannotFoundAddressTest() {
        // given
        given(queryUserSpi.existsUserById(anyLong()))
                .willReturn(true);
        given(queryAddressSpi.findAddressByMemberId(anyLong()))
                .willThrow(Address.AddressNotFoundException.class);

        // when
        ThrowingCallable method = () -> parentUseCase.getParentInfo(anyLong());

        // then
        assertThatThrownBy(method).isInstanceOf(Address.AddressNotFoundException.class);
    }

    @Test
    @DisplayName("유저가 부모 정보를 기입하지 않은 케이스")
    void cannotFoundParentTest() {
        // given
        given(queryUserSpi.existsUserById(anyLong()))
                .willReturn(true);
        given(queryAddressSpi.findAddressByMemberId(anyLong()))
                .willReturn(Optional.of(dummyAddress()));
        given(queryParentSpi.findParentByMemberId(anyLong()))
                .willThrow(Parent.ParentNotFoundException.class);

        // when
        ThrowingCallable method = () -> parentUseCase.getParentInfo(anyLong());

        // then
        assertThatThrownBy(method).isInstanceOf(Parent.ParentNotFoundException.class);
    }

    @Test
    @DisplayName("유저 부모 정보 조회")
    void findParentInfo() {
        // given
        final Address dummyAddress = dummyAddress("Method Area", "12-34", (short) 12345);
        final Parent dummyParent = dummyParent("admin", "admin", "010-0000-0000");
        given(queryUserSpi.existsUserById(anyLong()))
                .willReturn(true);
        given(queryAddressSpi.findAddressByMemberId(anyLong()))
                .willReturn(Optional.of(dummyAddress));
        given(queryParentSpi.findParentByMemberId(anyLong()))
                .willReturn(Optional.of(dummyParent));

        // when
        MemberParentVO parentVO = parentUseCase.getParentInfo(anyLong());

        // then
        assertThat(parentVO).isNotNull();
        assertThat(parentVO.toParentDomain()).isEqualTo(dummyParent);
        assertThat(parentVO.toAddressDomain()).isEqualTo(dummyAddress);

        // verify
        verify(queryUserSpi).existsUserById(anyLong());
        verify(queryAddressSpi).findAddressByMemberId(anyLong());
        verify(queryParentSpi).findParentByMemberId(anyLong());
    }
}
