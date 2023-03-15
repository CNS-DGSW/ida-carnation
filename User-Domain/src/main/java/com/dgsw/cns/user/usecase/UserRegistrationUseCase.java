package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserRegistrationApi;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.spi.UserRegistrationSpi;
import com.dgsw.cns.user.spi.certification.PasswordCertificationSpi;
import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.vo.MemberRegistrationVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserRegistrationUseCase implements UserRegistrationApi {

    private final UserRegistrationSpi userRegistrationSpi;
    private final PasswordCertificationSpi passwordCertificationSpi;
    private final EmailCertificationSpi emailCertificationSpi;
    private final QueryUserSpi queryUserSpi;

    @Override
    public void registerUser(MemberRegistrationVO memberRegistrationVO) {
        // 이미 이메일 인증은 한 후, 회원가입이 이루어짐
        if (queryUserSpi.existsUserByEmail(memberRegistrationVO.getEmail())) {
            throw new Member.EmailAlreadyExistsException();
        }

        if (emailCertificationSpi
                .matchesVerificationCode(memberRegistrationVO.getVerificationCode())) {
            throw new Member.VerificationCodeMismatchException();
        }

        userRegistrationSpi.register(
                memberRegistrationVO.getEmail(),
                passwordCertificationSpi.encryptPassword(memberRegistrationVO.getPassword()),
                memberRegistrationVO.getVerificationCode()
        );
    }
}
