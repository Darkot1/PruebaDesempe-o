package com.riwi.pruebaRiwi.application.mapper;

import com.riwi.pruebaRiwi.application.dto.request.LoadEntityRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.LoadEntityResponseDto;
import com.riwi.pruebaRiwi.domain.model.LoadEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoadEntityMapper {


    LoadEntity toEntity(LoadEntityRequestDto requestDto);
    LoadEntityResponseDto toResponseDto(LoadEntity loadEntity);

}
