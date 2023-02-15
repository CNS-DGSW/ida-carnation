package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserRegistrationApi;
import com.dgsw.cns.user.spi.UserRegistrationSpi;
import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.vo.MemberRegistrationVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserRegistrationUseCase implements UserRegistrationApi {

    private final UserRegistrationSpi userRegistrationSpi;
    private final EmailCertificationSpi emailCertificationSpi;
    private final QueryUserSpi queryUserSpi;

    @Override
    public void registerUser(MemberRegistrationVO memberRegistrationVO) {
        // 이미 이메일 인증은 한 후, 회원가입이 이루어짐
        if (queryUserSpi.existsUserByEmail(memberRegistrationVO.getEmail())) {
            throw new RuntimeException("이메일이 이미 존재합니다.");
        }

        if(emailCertificationSpi.matches(memberRegistrationVO.getVerificationCode())){
            throw new RuntimeException("인증번호가 일치하지 않습니다.");
        }

        userRegistrationSpi.register(
                memberRegistrationVO.getEmail(),
                userRegistrationSpi.encryptPassword(memberRegistrationVO.getPassword()),
                memberRegistrationVO.getVerificationCode()
        );
    }
}
