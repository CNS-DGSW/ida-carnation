package com.dgsw.cns.user.api;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.domain.Privacy;
import com.dgsw.cns.user.domain.enums.Gender;
import com.dgsw.cns.user.spi.query.QueryPrivacySpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.usecase.UserInfoUseCase;
import com.dgsw.cns.user.vo.MemberInfoVO;
import org.assertj.core.api.ThrowableAssert;
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
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserInfoApiTest {

    @Mock
    private QueryUserSpi queryUserSpi;

    @Mock
    private QueryPrivacySpi queryPrivacySpi;

    @InjectMocks
    private UserInfoUseCase userInfoUseCase;

    @Test
    @DisplayName("회원가입을 하지 않은 케이스")
    void cannotFoundUser() {
        // given
        given(queryUserSpi.findUserById(anyLong()))
                .willThrow(Member.MemberNotFoundException.class);

        // when
        ThrowableAssert.ThrowingCallable method = () -> userInfoUseCase.getUserInfo(1L);

        // then
        assertThatThrownBy(method).isInstanceOf(Member.MemberNotFoundException.class);
    }

    @Test
    @DisplayName("회원 정보 조회")
    void findUserById() {
        // given
        final Long id = 1L;
        final String name = "a", telephone = "010-1111-2222";
        final Member member = Member.builder()
                .id(id)
                .name(name)
                .build();
        final Privacy privacy = Privacy.builder()
                .userId(id)
                .contact(telephone)
                .gender(Gender.MALE)
                .birth(LocalDate.now())
                .build();
        given(queryUserSpi.findUserById(anyLong()))
                .willReturn(Optional.of(member));
        given(queryPrivacySpi.findPrivacyByMemberId(anyLong()))
                .willReturn(Optional.of(privacy));

        // when
        final MemberInfoVO infoVO = userInfoUseCase.getUserInfo(anyLong());

        // then
        assertThat(infoVO).isNotNull();
        assertThat(infoVO.getName()).isEqualTo(name);
        assertThat(infoVO.getBirth()).isNotBlank();
        assertThat(infoVO.getGender()).isNotBlank();
        assertThat(infoVO.getTelephone()).isEqualTo(telephone);

        // verify
        verify(queryUserSpi).findUserById(anyLong());
    }
}
