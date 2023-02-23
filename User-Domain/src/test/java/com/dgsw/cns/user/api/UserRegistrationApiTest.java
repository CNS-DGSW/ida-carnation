package com.dgsw.cns.user.api;

import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.usecase.UserRegistrationUseCase;
import com.dgsw.cns.user.vo.MemberRegistrationVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

@ExtendWith(MockitoExtension.class)
class UserRegistrationApiTest {

    @Mock
    private EmailCertificationSpi emailCertificationSpi;

    @Mock
    private QueryUserSpi queryUserSpi;

    @InjectMocks
    private UserRegistrationUseCase registrationUseCase;

    MemberRegistrationVO dummyValueObject() {
        return dummyValueObject("", "", "");
    }

    MemberRegistrationVO dummyValueObject(String code) {
        return dummyValueObject("", "", code);
    }

    MemberRegistrationVO dummyValueObject(String email, String password, String code) {
        return new MemberRegistrationVO(email, password, code);
    }

    @Test
    @DisplayName("이미 가입된 이메일")
    void alreadyUsedEmail() {
        // given
        given(queryUserSpi.existsUserByEmail(anyString()))
                .willThrow(Member.EmailAlreadyExistsException.class);

        // when
        ThrowingCallable method = () -> registrationUseCase
                .registerUser(dummyValueObject());

        // then
        assertThatThrownBy(method).isInstanceOf(Member.EmailAlreadyExistsException.class);
    }

    @Test
    @DisplayName("인증코드가 동일하지않음")
    void certificationCodeIsMismatch() {
        // given
        given(queryUserSpi.existsUserByEmail(anyString()))
                .willReturn(false);
        given(emailCertificationSpi.matchesVerificationCode(anyString()))
                .willThrow(Member.VerificationCodeMismatchException.class);

        // when
        ThrowingCallable method = () -> registrationUseCase
                .registerUser(dummyValueObject(anyString()));

        // then
        assertThatThrownBy(method).isInstanceOf(Member.VerificationCodeMismatchException.class);
    }
}
