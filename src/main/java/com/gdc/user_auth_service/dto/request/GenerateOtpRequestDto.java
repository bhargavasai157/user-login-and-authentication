package com.gdc.user_auth_service.dto.request;

import com.gdc.user_auth_service.enums.OtpType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateOtpRequestDto {
    private String phone;
    private OtpType otpType;
}
