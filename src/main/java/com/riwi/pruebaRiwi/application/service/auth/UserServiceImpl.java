package com.riwi.pruebaRiwi.application.service.auth;

import com.riwi.pruebaRiwi.application.dto.request.UserRequestDto;
import com.riwi.pruebaRiwi.application.dto.response.AuthUserResponseDto;
import com.riwi.pruebaRiwi.application.dto.response.UserResponseDto;
import com.riwi.pruebaRiwi.application.mapper.UserEntityMapper;
import com.riwi.pruebaRiwi.domain.exception.InvalidCredentialException;
import com.riwi.pruebaRiwi.domain.model.UserEntity;
import com.riwi.pruebaRiwi.domain.port.interfaces.IUserService;
import com.riwi.pruebaRiwi.infrastructure.helper.JwtUtil;
import com.riwi.pruebaRiwi.infrastructure.persistence.UserRepository;
import com.riwi.pruebaRiwi.util.enums.RoleUser;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    public final UserRepository userRepository;

    @Autowired
    private final UserEntityMapper userMapper;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtUtil jwtUtil;


    @Override
    public AuthUserResponseDto register(UserRequestDto requestDto, RoleUser role) {
        //Verifica si el usuario existe
        UserEntity userDB = userRepository.findByNameOrEmail(requestDto.getName(),requestDto.getEmail());

        //Verifica si el usuario ya existe
        if(userDB != null){
            throw new InvalidCredentialException("Username register");
        }

        UserEntity user = UserEntity.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .role(role)
                .enabled(true)
                .build();

        user = userRepository.save(user);

        //Genera la respuesta de registro e el token JWT
        return AuthUserResponseDto.builder()
                .message(user.getRole() + " successfully authenticated")
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole().name())
                .createdBy(user.getCreatedBy())
                .updatedBy(user.getUpdatedBy())
                .build();

    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("User not found!");
        }

        userRepository.deleteById(id);
        }

        @Override
        public List<UserResponseDto> readAll() {
        List<UserEntity> listUser = userRepository.findAll();

        return listUser.stream()
                .map(userMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto readById(Long id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found!"));
        return userMapper.toResponseDto(user);
    }


    @Override
    public UserEntity update(UserRequestDto requestDto, Long id) {
        return userRepository.findById(id).map(users -> {
                    UserEntity user = userMapper.toEntity(requestDto);
                    user.setId(users.getId());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new EntityNotFoundException("User with ID: " + "'" + id + "'" + " not found!"));
    }
}
