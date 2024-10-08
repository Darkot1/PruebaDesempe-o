package com.riwi.pruebaRiwi.application.mapper;

import com.riwi.pruebaRiwi.application.dto.request.PaletRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.PaletResponseDto;
import com.riwi.pruebaRiwi.domain.model.Palet;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaletMapper {

    Palet toEntity (PaletRequestDto requestDto);

    PaletResponseDto toResponseDto (Palet palet);
}
