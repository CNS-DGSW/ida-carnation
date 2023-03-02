package com.dgsw.cns.user.domain;

import com.dgsw.cns.exception.client.ConflictException;
import com.dgsw.cns.exception.client.ForbiddenException;
import com.dgsw.cns.exception.client.NotFoundException;
import com.dgsw.cns.exception.client.UnauthorizedException;
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

    public static final class MemberNotFoundException extends NotFoundException {
        @Serial
        private static final long serialVersionUID = -5317178839823250949L;

        public MemberNotFoundException() {
            super("해당 회원이 존재하지 않습니다.");
        }

        public MemberNotFoundException(String message) {
            super(message);
        }

        public MemberNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public MemberNotFoundException(Throwable cause) {
            super(cause);
        }
    }

    public static final class EmailAlreadyExistsException extends ConflictException {
        @Serial
        private static final long serialVersionUID = 5337685738358478423L;

        public EmailAlreadyExistsException() {
            super("이미 사용 중인 이메일입니다.");
        }

        public EmailAlreadyExistsException(String message) {
            super(message);
        }

        public EmailAlreadyExistsException(String message, Throwable cause) {
            super(message, cause);
        }

        public EmailAlreadyExistsException(Throwable cause) {
            super(cause);
        }
    }

    public static final class PasswordMismatchException extends UnauthorizedException {
        @Serial
        private static final long serialVersionUID = 1058051660673119800L;

        public PasswordMismatchException() {
            super("비밀번호가 일치하지 않습니다.");
        }

        public PasswordMismatchException(String message) {
            super(message);
        }

        public PasswordMismatchException(String message, Throwable cause) {
            super(message, cause);
        }

        public PasswordMismatchException(Throwable cause) {
            super(cause);
        }
    }

    public static final class VerificationCodeMismatchException
            extends ForbiddenException {
        @Serial
        private static final long serialVersionUID = 3141750005630367740L;

        public VerificationCodeMismatchException() {
            super("인증코드가 일치하지 않습니다.");
        }

        public VerificationCodeMismatchException(String message) {
            super(message);
        }

        public VerificationCodeMismatchException(String message, Throwable cause) {
            super(message, cause);
        }

        public VerificationCodeMismatchException(Throwable cause) {
            super(cause);
        }
    }
}
