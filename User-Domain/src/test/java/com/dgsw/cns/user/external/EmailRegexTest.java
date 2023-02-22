package com.dgsw.cns.user.external;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class EmailRegexTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    static class Data {
        @Email(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
        private final String email;

        public Data(String email) {
            this.email = email;
        }
    }

    @Test
    void gmailTest() {
        // given
        final Data data = new Data("1@gmail.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void naverTest() {
        // given
        final Data data = new Data("1@naver.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void daumTest() {
        // given
        final Data data = new Data("1@daum.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void yahooTest() {
        // given
        final Data data = new Data("1@yahoo.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void nateTest() {
        // given
        final Data data = new Data("1@nate.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void koreaTest() {
        // given
        final Data data = new Data("1@korea.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void dgswTest() {
        // given
        final Data data = new Data("1@dgsw.hs.kr");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    void failTest() {
        // given
        final Data data = new Data("1#naver.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations.size()).isEqualTo(1);
    }

}
