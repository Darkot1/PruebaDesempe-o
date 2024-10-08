package com.riwi.pruebaRiwi.infrastructure.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;


    private final String[] CARRIER_ENDPOINTS = {

    };

    private final String[] ADMIN_ENDPOINTS = {
            "api/users/**",
            "api/pallets/**",
            "api/loads/**"
    };
    private final String[] AUTH_ENDPOINTS = {
            "api/auth/**",
            "api/users/register/user",
            "/swagger-ui/**",
            "/v3/api-docs/**"

    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF ya que se usa JWT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(AUTH_ENDPOINTS).permitAll() // Permitir acceso a endpoints públicos
                        .requestMatchers(ADMIN_ENDPOINTS).hasAuthority("ROLE_ADMIN")// Solo ADMIN puede acceder a estos endpoints
                        .requestMatchers(CARRIER_ENDPOINTS).hasAuthority("ROLE_CARRIER")
                        .anyRequest().authenticated()
                )
                .authenticationProvider(authenticationProvider) // Configurar el proveedor de autenticación
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


}
