package com.gdc.user_auth_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class VerifyOtpResponseDto {
    private String message;
    private UUID userId;
}
