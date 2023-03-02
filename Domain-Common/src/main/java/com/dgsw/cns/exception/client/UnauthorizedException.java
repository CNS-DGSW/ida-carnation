package com.dgsw.cns.exception.client;

import com.dgsw.cns.exception.BusinessException;

import java.io.Serial;

public class UnauthorizedException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -3887797664991378760L;

    public UnauthorizedException() {
        super(401, "권한이 없는 요청입니다.");
    }

    public UnauthorizedException(String message) {
        super(401, message);
    }

    public UnauthorizedException(String message, Throwable cause) {
        super(401, message, cause);
    }

    public UnauthorizedException(Throwable cause) {
        super(401, cause);
    }
}
