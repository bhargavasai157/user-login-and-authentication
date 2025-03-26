package com.gdc.user_auth_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenerateOtpResponseDto {
    private String message;
    private String otp;

}
