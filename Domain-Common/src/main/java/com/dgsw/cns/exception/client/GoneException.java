package com.dgsw.cns.exception.client;

import com.dgsw.cns.exception.BusinessException;

import java.io.Serial;

public class GoneException extends BusinessException {

    @Serial
    private static final long serialVersionUID = 5033082193438936786L;

    public GoneException() {
        super(410, "서버에서 임의로 삭제되어 더 이상 자원을 찾을 수 없습니다.");
    }

    public GoneException(String message) {
        super(410, message);
    }

    public GoneException(String message, Throwable cause) {
        super(410, message, cause);
    }

    public GoneException(Throwable cause) {
        super(410, cause);
    }
}
