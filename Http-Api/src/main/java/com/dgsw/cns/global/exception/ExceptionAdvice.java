package com.dgsw.cns.global.exception;

import com.dgsw.cns.exception.BusinessException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@Log4j2
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> onBusinessException(BusinessException exception) {
        return ResponseEntity
                .status(exception.getCode())
                .body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> onUncaughtException(RuntimeException exception) {
        log.error(exception.getMessage());
        log.error(Arrays.stream(exception.getStackTrace())
                .map(Object::toString)
                .collect(Collectors.joining("\n")));

        return ResponseEntity
                .status(500)
                .body(new ExceptionResponse("Unknown error"));
    }
}
