package com.dgsw.cns.user.usecase.cetification;

import com.dgsw.cns.annotations.UseCase;
import com.dgsw.cns.user.api.certification.UserRecoveryApi;
import com.dgsw.cns.user.domain.Member;
import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;
import com.dgsw.cns.user.spi.certification.email.RandomCodeSpi;
import com.dgsw.cns.user.spi.query.QueryUserSpi;
import com.dgsw.cns.user.vo.certification.MemberRecoveryEmailVO;
import com.dgsw.cns.user.vo.certification.MemberRecoveryIdVO;
import com.dgsw.cns.user.vo.certification.MemberRecoveryPasswordVO;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.NoSuchElementException;

@UseCase
@RequiredArgsConstructor
public class UserRecoveryUseCase implements UserRecoveryApi {

    // TODO: 2023-02-16 UserRecoveryApi 가 SRP 를 위배하는 상태임
    // 하지만 이메일 인증은 회원 리커버리 파트 중 하나이기에 어찌보면 SRP 를 제대로 지킨 것일 수 도 있음

    private final QueryUserSpi queryUserSpi;
    private final EmailCertificationSpi emailCertificationSpi;
    private final RandomCodeSpi<Object> randomCodeSpi;

    @Override
    public MemberRecoveryEmailVO findIdByName(MemberRecoveryIdVO memberRecoveryIdVO) {
        final String name = memberRecoveryIdVO.getName();
        final LocalDate birth;
        try {
            birth = stringToLocalDate(memberRecoveryIdVO.getBirth());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }

        return new MemberRecoveryEmailVO(queryUserSpi.findEmailByNameAndBirth(name, birth));
    }

    @Override
    public void resetPassword(MemberRecoveryPasswordVO memberRecoveryPasswordVO) {
        // 이미 인증 번호를 받았다고 가정된 상태
        final String email = memberRecoveryPasswordVO.getEmail();
        final String password = memberRecoveryPasswordVO.getNewPassword();
        final String code = memberRecoveryPasswordVO.getVerificationCode();

        if (!emailCertificationSpi.matches(code)) {
            throw new IllegalStateException("인증코드와 일치하지 않습니다.");
        }

        Member member = queryUserSpi.findUserByEmail(email)
                .orElseThrow(() -> new NoSuchElementException("존재하지 않는 회원입니다."));
        member.setPassword(password);
        queryUserSpi.saveUser(member);
    }

    @Override
    public void sendVerificationCode(String email) {
        final Object code = randomCodeSpi.createRandomCode();
        randomCodeSpi.saveRandomCode(code);
        emailCertificationSpi.sendCertificationCode(email, code);
    }

    protected LocalDate stringToLocalDate(String data) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return LocalDate.from(dateFormat.parse(data).toInstant());
    }
}
