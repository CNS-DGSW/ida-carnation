package com.dgsw.cns.exception.client;

import com.dgsw.cns.exception.BusinessException;

import java.io.Serial;

public class ConflictException extends BusinessException {

    @Serial
    private static final long serialVersionUID = 7199746423396108406L;

    public ConflictException() {
        super(409, "리소스 간 충돌이 발생하였습니다.");
    }

    public ConflictException(String message) {
        super(409, message);
    }

    public ConflictException(String message, Throwable cause) {
        super(409, message, cause);
    }

    public ConflictException(Throwable cause) {
        super(409, cause);
    }
}
