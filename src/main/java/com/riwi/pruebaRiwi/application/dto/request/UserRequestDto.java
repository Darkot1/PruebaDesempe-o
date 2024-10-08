package com.riwi.pruebaRiwi.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotBlank(message = "name required!")
    private String name;

    @NotBlank(message = "email required!")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "password required!")
    private String password;
}
