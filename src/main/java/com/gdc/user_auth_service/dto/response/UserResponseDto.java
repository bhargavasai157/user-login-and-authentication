package com.gdc.user_auth_service.dto.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserResponseDto {

    private UUID id;
    private String message;
}
