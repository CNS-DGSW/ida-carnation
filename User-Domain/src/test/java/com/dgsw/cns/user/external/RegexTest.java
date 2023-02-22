package com.dgsw.cns.user.external;

import com.dgsw.cns.user.vo.MemberRegistrationVO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    @DisplayName("이메일이 null 인 케이스")
    void emailIsNullTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO(null, "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("이메일이 빈 문자열인 케이스")
    void emailIsEmptyTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("", "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("이메일이 공백인 케이스")
    void emailIsBlankTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO(" ", "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("이메일이 정규형에 규합하지 않은 케이스")
    void emailIsInvalidTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a!gmail.com", "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("비밀번호가 8자리 미만인 케이스")
    void passwordLengthIsTooShortTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "1234", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("비밀번호가 빈 문자열인 케이스")
    void passwordIsEmpty() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("인증코드가 6자리 미만인 케이스")
    void codeLengthIsTooShortTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "12345678", "1");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("인증코드가 6자리 초과인 케이스")
    void codeLengthIsTooLongTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "12345678", "1234567890");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    @DisplayName("인증코드가 빈 문자열인 케이스")
    void codeIsEmptyTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "12345678", "");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }
}
