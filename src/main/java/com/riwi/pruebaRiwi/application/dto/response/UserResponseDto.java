package com.riwi.pruebaRiwi.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UserResponseDto {

    private String createdBy;

    private String updatedBy;

    private Long id;

    private String name;

    private String email;

    private String role;
}
