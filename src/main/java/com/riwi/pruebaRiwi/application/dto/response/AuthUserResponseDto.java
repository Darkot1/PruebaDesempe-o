package com.riwi.pruebaRiwi.application.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class AuthUserResponseDto extends UserResponseDto {
    private String message;
    private String token;
}
