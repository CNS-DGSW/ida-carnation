package com.dgsw.cns.user.domain;

import com.dgsw.cns.exception.client.ConflictException;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;
import java.util.Objects;

@Getter
@Builder
public class Merit {

    private final String code;
    private final String department;

    public static final class ForgeryMeritCodeException extends ConflictException {
        @Serial
        private static final long serialVersionUID = -7797890304000773116L;

        public ForgeryMeritCodeException() {
            super("저장되지않은 보훈 번호입니다.");
        }

        public ForgeryMeritCodeException(String message) {
            super(message);
        }

        public ForgeryMeritCodeException(String message, Throwable cause) {
            super(message, cause);
        }

        public ForgeryMeritCodeException(Throwable cause) {
            super(cause);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Merit merit = (Merit) o;
        return Objects.equals(code, merit.code) && Objects.equals(department, merit.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, department);
    }
}
