package com.dgsw.cns.exception.client;

import com.dgsw.cns.exception.BusinessException;

import java.io.Serial;

public class NotFoundException extends BusinessException {

    @Serial
    private static final long serialVersionUID = 8203154193900797635L;

    public NotFoundException() {
        super(404, "존재하지 않은 URI 혹은 리소스입니다.");
    }

    public NotFoundException(String message) {
        super(404, message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(404, message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(404, cause);
    }
}
