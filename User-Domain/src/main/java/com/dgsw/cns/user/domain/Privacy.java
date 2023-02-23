package com.dgsw.cns.user.domain;

import com.dgsw.cns.exception.BusinessException;
import com.dgsw.cns.user.domain.enums.Gender;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Builder
public class Privacy {

    private final Long userId;

    private final LocalDate birth;

    private final Gender gender;

    private final String contact;

    private String meritCode;

    public void updateMeritCode(String meritCode) {
        this.meritCode = meritCode;
    }

    public boolean isCodeNull() {
        return (meritCode == null);
    }

    public static final class PrivacyNotFoundException extends BusinessException {
        @Serial
        private static final long serialVersionUID = 3846624041980964378L;

        public PrivacyNotFoundException() {
            super(404, "개인정보가 존재하지 않습니다.");
        }

        public PrivacyNotFoundException(int code, String message) {
            super(code, message);
        }

        public PrivacyNotFoundException(String message, Throwable cause) {
            super(404, message);
            super.initCause(cause);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privacy privacy = (Privacy) o;
        return Objects.equals(userId, privacy.userId) && Objects.equals(birth, privacy.birth)
                && gender == privacy.gender && Objects.equals(contact, privacy.contact)
                && Objects.equals(meritCode, privacy.meritCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, birth, gender, contact, meritCode);
    }
}
