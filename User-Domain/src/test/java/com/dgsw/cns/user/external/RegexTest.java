package com.dgsw.cns.user.external;

import com.dgsw.cns.user.vo.MemberRegistrationVO;
import com.dgsw.cns.user.vo.MemberVeteranVO;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RegexTest {

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
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("이메일이 빈 문자열인 케이스")
    void emailIsEmptyTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("", "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("이메일이 공백인 케이스")
    void emailIsBlankTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO(" ", "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("이메일이 정규형에 규합하지 않은 케이스")
    void emailIsInvalidTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a!gmail.com", "12345678", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("비밀번호가 8자리 미만인 케이스")
    void passwordLengthIsTooShortTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "1234", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("비밀번호가 빈 문자열인 케이스")
    void passwordIsEmpty() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "", "123456");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("인증코드가 6자리 미만인 케이스")
    void codeLengthIsTooShortTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "12345678", "1");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("인증코드가 6자리 초과인 케이스")
    void codeLengthIsTooLongTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "12345678", "1234567890");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("인증코드가 빈 문자열인 케이스")
    void codeIsEmptyTest() {
        // given
        final MemberRegistrationVO vo = new MemberRegistrationVO("a@gmail.com", "12345678", "");

        // when
        Set<ConstraintViolation<MemberRegistrationVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("보훈청이 빈 문자열인 케이스")
    void departmentIsEmptyTest() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("", "00-000000");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);
    }

    @Test
    @DisplayName("보훈번호가 빈 문자열인 케이스")
    void meritCodeIsEmptyTest() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("어드민 보훈청", "");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(2);              // size, pattern
    }

    @Test
    @DisplayName("보훈번호가 9자리 미만인 케이스")
    void meritCodeLengthIsTooShortTest() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("어드민 보훈청", "1");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(2);              // size, pattern
    }

    @Test
    @DisplayName("보훈번호가 9자리 초과인 케이스")
    void meritCodeLengthIsTooLongTest() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("어드민 보훈청", "12-34567890");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(2);              // size, pattern
    }

    @Test
    @DisplayName("보훈번호의 규격을 어긴 케이스")
    void meritCodeIsMismatchTest() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("어드민 보훈청", "12345678");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(2);              // size, pattern
    }

    @Test
    @DisplayName("보훈번호가 숫자가 아닌 문자가 1개이상 포함된 케이스")
    void meritCodeIsAllNumber() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("어드민 보훈청", "ab-123456");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations).hasSize(1);              // pattern
    }

    @Test
    @DisplayName("보훈번호가 제대로 입력된 케이스")
    void meritCodeIsCorrect() {
        // given
        final MemberVeteranVO vo = new MemberVeteranVO("어드민 보훈청", "12-345678");

        // when
        Set<ConstraintViolation<MemberVeteranVO>> violations = validator.validate(vo);

        // then
        assertThat(violations.size()).isZero();
    }

}
