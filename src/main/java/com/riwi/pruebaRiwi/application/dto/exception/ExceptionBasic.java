package com.riwi.pruebaRiwi.application.dto.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ExceptionBasic {
    private Integer code;
    private String status;
}
