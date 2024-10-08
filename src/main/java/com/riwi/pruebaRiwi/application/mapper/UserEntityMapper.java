package com.riwi.pruebaRiwi.application.mapper;

import com.riwi.pruebaRiwi.application.dto.request.UserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.UserResponseDto;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {


    UserEntity toEntity (UserRequestDto requestDto);
    UserResponseDto toResponseDto (UserEntity user);

}
