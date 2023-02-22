package com.dgsw.cns.user.domain;

import com.dgsw.cns.exception.BusinessException;
import com.dgsw.cns.user.domain.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.io.Serial;

@Getter
@Builder
public class Member {

    private final Long id;
    private final String email;
    private final String name;
    private String password;
    private final Role role;

    public void setPassword(String password) {
        this.password = password;
    }

    public static final class MemberNotFoundException extends BusinessException {
        @Serial
        private static final long serialVersionUID = -5317178839823250949L;

        public MemberNotFoundException() {
            super(404, "해당 회원이 존재하지 않습니다.");
        }

        public MemberNotFoundException(String message) {
            super(404, message);
        }

        public MemberNotFoundException(String message, Throwable cause) {
            super(404, message);
            super.initCause(cause);
        }
    }

    public static final class EmailAlreadyExistsException extends BusinessException {
        @Serial
        private static final long serialVersionUID = 5337685738358478423L;

        public EmailAlreadyExistsException() {
            super(409, "이미 사용 중인 이메일입니디.");
        }

        public EmailAlreadyExistsException(int code, String message) {
            super(code, message);
        }

        public EmailAlreadyExistsException(String message, Throwable cause) {
            super(409, message);
            super.initCause(cause);
        }
    }

    public static final class PasswordMismatchException extends BusinessException {
        @Serial
        private static final long serialVersionUID = 1058051660673119800L;

        public PasswordMismatchException() {
            super(401, "비밀번호가 일치하지 않습니다.");
        }

        public PasswordMismatchException(int code, String message) {
            super(code, message);
        }

        public PasswordMismatchException(String message, Throwable cause) {
            super(401, message);
            super.initCause(cause);
        }
    }

    public static final class CertificationCodeMismatchException
            extends BusinessException {
        @Serial
        private static final long serialVersionUID = 3141750005630367740L;

        public CertificationCodeMismatchException() {
            super(401, "인증코드가 일치하지 않습니다.");
        }

        public CertificationCodeMismatchException(int code, String message) {
            super(code, message);
        }

        public CertificationCodeMismatchException(String message, Throwable cause) {
            super(401, message);
            super.initCause(cause);
        }
    }
}
