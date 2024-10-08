package com.riwi.pruebaRiwi.domain.port.interfaces;

import com.riwi.pruebaRiwi.application.dto.request.auth.AuthUserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;

public interface IAuthService{
    public AuthUserResponseDto login (AuthUserRequestDto reqest);
}
