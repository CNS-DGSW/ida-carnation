package com.dgsw.cns.exception.client;

import com.dgsw.cns.exception.BusinessException;

import java.io.Serial;

public class BadRequestException extends BusinessException {

    @Serial
    private static final long serialVersionUID = -6757242672830219821L;

    public BadRequestException() {
        super(400, "잘못된 요청입니다.");
    }

    public BadRequestException(String message) {
        super(400, message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(400, message, cause);
    }

    public BadRequestException(Throwable cause) {
        super(400, cause);
    }
}
