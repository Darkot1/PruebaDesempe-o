package com.riwi.pruebaRiwi.application.dto.request;

import com.riwi.pruebaRiwi.domain.model.Palet;
import com.riwi.pruebaRiwi.util.enums.StatusLoad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoadEntityRequestDto {

    private Long id;

    @NotBlank(message = "description required!")
    private String description;

    @NotEmpty(message = "weight required!")
    private Integer weight;

    @NotEmpty(message = "dimension required!")
    private Integer dimension;

    @NotEmpty(message = "status required!")
    private StatusLoad status;

    private Palet palet;
}
