package com.riwi.pruebaRiwi.domain.port.interfaces;

import com.riwi.pruebaRiwi.application.dto.request.UserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;
import com.riwi.pruebaRiwi.application.dto.response.UserResponseDto;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import com.riwi.pruebaRiwi.domain.port.crud.*;
import com.riwi.pruebaRiwi.util.enums.RoleUser;

public interface IUserService extends
        ReadAll<UserResponseDto>,
        ReadById<UserResponseDto, Long>,
        Delete<Long> {

    public AuthUserResponseDto register(UserRequestDto requestDto, RoleUser role);


    UserEntity update(UserRequestDto requestDto, Long id);
}

