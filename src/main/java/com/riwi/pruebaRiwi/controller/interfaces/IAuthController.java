package com.riwi.pruebaRiwi.controller.interfaces;


import com.riwi.pruebaRiwi.application.dto.request.auth.AuthUserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAuthController {
    public ResponseEntity<AuthUserResponseDto> login (AuthUserRequestDto requestDto);
}
