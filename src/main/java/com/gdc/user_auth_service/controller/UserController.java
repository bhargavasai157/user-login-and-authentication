package com.gdc.user_auth_service.controller;

import com.gdc.user_auth_service.dto.request.UserRequestDto;
import com.gdc.user_auth_service.dto.response.UserResponseDto;
import com.gdc.user_auth_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto response = userService.registerUser(userRequestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
