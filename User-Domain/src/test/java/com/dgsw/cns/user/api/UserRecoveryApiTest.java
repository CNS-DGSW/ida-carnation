package com.dgsw.cns.user.api;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.usecase.cetification.UserRecoveryUseCase;
import com.dgsw.cns.user.vo.certification.MemberRecoveryIdVO;
import com.dgsw.cns.user.vo.certification.MemberRecoveryPasswordVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

@ExtendWith(MockitoExtension.class)
class UserRecoveryApiTest {

    @Mock
    private QueryUserSpi queryUserSpi;

    @Mock
    private EmailCertificationSpi emailCertificationSpi;

    @InjectMocks
    private UserRecoveryUseCase recoveryUseCase;

    MemberRecoveryIdVO dummyEmail() {
        return new MemberRecoveryIdVO("admin", "2023-02-22");
    }

    MemberRecoveryPasswordVO dummyPassword() {
        return new MemberRecoveryPasswordVO("admin@gmail.com", "12345678", "123456");
    }

    @Test
    @DisplayName("유저가 회원가입을 하지않은 케이스")
    void cannotFoundMemberTest() {
        // given
        given(queryUserSpi.findEmailByNameAndBirth(anyString(), any(LocalDate.class)))
                .willThrow(Member.MemberNotFoundException.class);

        // when
        ThrowingCallable method = () -> recoveryUseCase.findIdByName(dummyEmail());

        // then
        assertThatThrownBy(method).isInstanceOf(Member.MemberNotFoundException.class);
    }

    @Test
    @DisplayName("이메일 인증코드가 동일하지않은 케이스")
    void codeIsMismatchTest() {
        // given
        given(emailCertificationSpi.matchesVerificationCode(anyString()))
                .willThrow(Member.VerificationCodeMismatchException.class);

        // then
        ThrowingCallable method = () -> recoveryUseCase.resetPassword(dummyPassword());

        // then
        assertThatThrownBy(method)
                .isInstanceOf(Member.VerificationCodeMismatchException.class);
    }
}
