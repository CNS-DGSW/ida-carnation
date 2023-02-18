package com.dgsw.cns.user.external;

import com.dgsw.cns.user.spi.certification.email.EmailCertificationSpi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailRegexTest {

    private static final EmailCertificationSpi SPI = new EmailCertificationSpi() {
        @Override
        public boolean matches(String code) {
            return false;
        }

        @Override
        public void sendCertificationCode(String email, Object code) {

        }
    };

    @Test
    void gmailTest() {
        // given
        final String sample = "1@gmail.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void naverTest() {
        // given
        final String sample = "1@naver.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void daumTest() {
        // given
        final String sample = "1@daum.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void yahooTest() {
        // given
        final String sample = "1@yahoo.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void nateTest() {
        // given
        final String sample = "1@nate.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void koreaTest() {
        // given
        final String sample = "1@korea.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void dgswTest() {
        // given
        final String sample = "1@dgsw.hs.kr";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertTrue(result);
    }

    @Test
    void failTest() {
        // given
        final String sample = "1#naver.com";

        // when
        boolean result = SPI.validationEmail(sample);

        // verify
        assertFalse(result);
    }

}
