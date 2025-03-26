package com.gdc.user_auth_service.service;

import com.gdc.user_auth_service.dto.request.UserRequestDto;
import com.gdc.user_auth_service.dto.response.UserResponseDto;
import com.gdc.user_auth_service.domain.entity.User;
import com.gdc.user_auth_service.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
@Transactional /*this means all the database operations
in this method are part of a single transaction.if any operation fails,
the transaction is rolled back. */

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserResponseDto registerUser(UserRequestDto userRequestDto) {
        if (userRepository.findByPhone(userRequestDto.getPhone()).isPresent()) {
            throw new RuntimeException("Phone number already registered!");
        }

        if (userRepository.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        User user = User.builder()
                .name(userRequestDto.getName())
                .age(userRequestDto.getAge())
                .gender(userRequestDto.getGender())
                .phone(userRequestDto.getPhone())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .isVerified(false)
                .createdAt(new Timestamp(System.currentTimeMillis()))
                .street(userRequestDto.getStreet())
                .city(userRequestDto.getCity())
                .state(userRequestDto.getState())
                .zipCode(userRequestDto.getZipCode())
                .country(userRequestDto.getCountry())
                .addressCreatedAt(new Timestamp(System.currentTimeMillis()))
                .build();

        userRepository.save(user);
        return new UserResponseDto(user.getId(), "User registered successfully!");
    }

}
