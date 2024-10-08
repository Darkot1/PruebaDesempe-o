package com.riwi.pruebaRiwi.application.exception;


import com.riwi.pruebaRiwi.application.dto.exception.ExceptionBasic;
import com.riwi.pruebaRiwi.application.dto.exception.ExceptionResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.stream.Collectors;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class ValidationError {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionBasic handleValidationException(MethodArgumentNotValidException exception) {
        String errors = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return ExceptionResponse.builder()
                .code(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .status(HttpStatus.UNPROCESSABLE_ENTITY.name())
                .message(errors)
                .build();
    }
}