package com.riwi.pruebaRiwi.controller.implement;

import com.riwi.pruebaRiwi.application.dto.request.auth.AuthUserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;
import com.riwi.pruebaRiwi.controller.interfaces.IAuthController;
import com.riwi.pruebaRiwi.domain.port.interfaces.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Tag(name = "Authentication", description = "Manages authentication request.")
@CrossOrigin("*")
public class AuthControllerImpl implements IAuthController {

    @Autowired
    private final IAuthService authService;


    @PostMapping("login")
    @Operation(
            summary = "Authenticate a user.",
            description = "Provides a user's data to generate a token that allows them to use private endpoints if their role allows it."
    )
    @Override
    public ResponseEntity<AuthUserResponseDto> login(@Validated @RequestBody AuthUserRequestDto requestDto) {
        return ResponseEntity.ok(this.authService.login(requestDto));
    }
}
