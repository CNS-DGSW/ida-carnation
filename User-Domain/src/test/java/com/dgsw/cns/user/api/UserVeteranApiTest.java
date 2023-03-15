package com.dgsw.cns.user.api;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.usecase.UserVeteranUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

@ExtendWith(MockitoExtension.class)
class UserVeteranApiTest {

    @Mock
    private QueryUserSpi queryUserSpi;

    @InjectMocks
    private UserVeteranUseCase veteranUseCase;

    @Test
    @DisplayName("유저가 회원가입을 하지않은 케이스")
    void cannotFoundMemberTest() {
        // given
        given(queryUserSpi.existsUserById(anyLong()))
                .willThrow(Member.MemberNotFoundException.class);

        // when
        ThrowingCallable method = () -> veteranUseCase.getVeteranInfo(anyLong());

        // then
        assertThatThrownBy(method).isInstanceOf(Member.MemberNotFoundException.class);
    }
}
