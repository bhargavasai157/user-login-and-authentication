package com.gdc.user_auth_service.service;

import com.gdc.user_auth_service.dto.request.UserRequestDto;
import com.gdc.user_auth_service.dto.response.UserResponseDto;


public interface UserService {
    UserResponseDto registerUser(UserRequestDto userRequestDto);
}
