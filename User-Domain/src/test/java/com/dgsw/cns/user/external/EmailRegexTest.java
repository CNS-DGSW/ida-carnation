package com.dgsw.cns.user.external;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"1@gmail.com", "1@naver.com", "1@daum.com", "1@yahoo.com",
            "1@nate.com", "1@korea.com", "1@dgsw.hs.kr"})
    void emailRegexTest(final String email) {
        // given
        final Data data = new Data(email);

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void failTest() {
        // given
        final Data data = new Data("1#naver.com");

        // when
        Set<ConstraintViolation<Data>> violations = validator.validate(data);

        // then
        assertThat(violations).hasSize(1);
    }

}
