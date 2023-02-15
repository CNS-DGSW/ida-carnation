package com.dgsw.cns.user.usecase;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.UserRegistrationApi;
import com.dgsw.cns.user.spi.UserRegistrationSpi;
import com.dgsw.cns.user.vo.MemberRegistrationVO;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UserRegistrationUseCase implements UserRegistrationApi {

    private final UserRegistrationSpi userRegistrationSpi;

    @Override
    public void registerUser(MemberRegistrationVO memberRegistrationVO) {

        if(userRegistrationSpi.validationEmail(memberRegistrationVO.getEmail())) {
            throw new RuntimeException("이메일이 이미 존재합니다.");
        }

        if(userRegistrationSpi.matches(memberRegistrationVO.getVerificationCode())){
            throw new RuntimeException("인증번호가 일치하지 않습니다.");
        }

        userRegistrationSpi.register(
                memberRegistrationVO.getEmail(),
                userRegistrationSpi.encryptPassword(memberRegistrationVO.getPassword()),
                memberRegistrationVO.getVerificationCode()
        );
    }
}
