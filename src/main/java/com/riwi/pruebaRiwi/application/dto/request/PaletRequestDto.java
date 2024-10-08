package com.riwi.pruebaRiwi.application.dto.request;

import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import com.riwi.pruebaRiwi.util.enums.StatusPalet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaletRequestDto {

    @NotEmpty(message = "capacity required!")
    private Integer capacity;

    @NotBlank(message = "ubication required!")
    private String ubication;

    @NotEmpty(message = "status required!")
    private StatusPalet status;

    private List<LoadEntity> loads;

    private UserEntity user;
}
