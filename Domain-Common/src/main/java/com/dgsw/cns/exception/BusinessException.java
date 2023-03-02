package com.dgsw.cns.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public abstract class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5963735616692049871L;

    private final int code;
    private final String message;

    protected BusinessException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    protected BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    protected BusinessException(int code, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = cause.getMessage();
    }
}
