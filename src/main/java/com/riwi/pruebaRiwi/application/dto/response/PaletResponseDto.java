package com.riwi.pruebaRiwi.application.dto.response;

import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import com.riwi.pruebaRiwi.util.enums.StatusPalet;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class PaletResponseDto {

    private Integer capacity;

    private String ubication;

    private StatusPalet status;

    private List<LoadEntity> loads;

    private UserEntity user;
}
