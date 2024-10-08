package com.riwi.pruebaRiwi.application.dto.response;

import com.riwi.pruebaRiwi.domain.model.Palet;
import com.riwi.pruebaRiwi.util.enums.StatusLoad;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
public class LoadEntityResponseDto {

    private Long id;

    private String description;

    private Integer weight;

    private StatusLoad status;

    private Palet palet;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
