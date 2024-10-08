package com.riwi.pruebaRiwi.application.service.auth;

import com.riwi.pruebaRiwi.application.dto.request.auth.AuthUserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import com.riwi.pruebaRiwi.domain.port.interfaces.IAuthService;
import com.riwi.pruebaRiwi.infrastructure.helper.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private final JwtUtil jwtUtil;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final AuthenticationManager authenticationManager;


    @Transactional
    @Override
    public AuthUserResponseDto login(AuthUserRequestDto request) {
        UserEntity user = (UserEntity) userDetailsService.loadUserByUsername(request.getIdentifier());

        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())){
            throw new RuntimeException("Invalid credentials");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getIdentifier(),
                request.getPassword()));
        return AuthUserResponseDto.builder()
                .message(user.getRole() + "Succesfull authentication")
                .token(jwtUtil.generateToken(user))
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }
}
