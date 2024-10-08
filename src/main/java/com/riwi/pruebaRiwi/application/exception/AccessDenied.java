package com.riwi.pruebaRiwi.application.exception;


import com.riwi.pruebaRiwi.application.dto.exception.ExceptionBasic;
import com.riwi.pruebaRiwi.application.dto.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AccessDenied {
    @ExceptionHandler(AccessDeniedException.class)
    public ExceptionBasic handleAccessDeniedException(AccessDeniedException exception) {
        return ExceptionResponse.builder()
                .code(HttpStatus.FORBIDDEN.value())
                .status(HttpStatus.FORBIDDEN.name())
                .message(exception.getMessage())
                .build();
    }
}
