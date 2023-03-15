package com.dgsw.cns.exception.client;

import com.dgsw.cns.exception.BusinessException;

import java.io.Serial;

public class ForbiddenException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -9021620174507117969L;

    public ForbiddenException() {
        super(403, "요청의 접근이 금지되었습니다.");
    }

    public ForbiddenException(String message) {
        super(403, message);
    }

    public ForbiddenException(String message, Throwable cause) {
        super(403, message, cause);
    }

    public ForbiddenException(Throwable cause) {
        super(403, cause);
    }
}
