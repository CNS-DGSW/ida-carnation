package com.dgsw.cns.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;

@Getter
@AllArgsConstructor
public abstract class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 5963735616692049871L;

    private final int code;
    private final String message;
}
