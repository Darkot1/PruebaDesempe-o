package com.riwi.pruebaRiwi.application.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserRequestDto {
    @NotBlank(message = "Identifier required")
    private String identifier;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}