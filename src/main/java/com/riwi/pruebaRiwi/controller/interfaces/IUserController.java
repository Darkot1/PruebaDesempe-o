package com.riwi.pruebaRiwi.controller.interfaces;

import com.riwi.pruebaRiwi.application.dto.request.UserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;
import com.riwi.pruebaRiwi.application.dto.response.UserResponseDto;
import com.riwi.pruebaRiwi.controller.crud.*;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import org.springframework.http.ResponseEntity;

public interface IUserController extends
        UpdateController<UserRequestDto, UserEntity, Long>,
        ReadAllController<UserResponseDto>,
        ReadByIdController<UserResponseDto, Long>,
        DeleteController<Long> {
    public ResponseEntity<AuthUserResponseDto> registerAdmin(UserRequestDto requestDto);

    public ResponseEntity<AuthUserResponseDto> registerRegularUser(UserRequestDto requestDto);

}
