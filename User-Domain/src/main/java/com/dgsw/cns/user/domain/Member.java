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

}
