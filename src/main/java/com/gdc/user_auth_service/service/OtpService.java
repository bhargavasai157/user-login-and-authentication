package com.gdc.user_auth_service.service;

import com.gdc.user_auth_service.dto.request.GenerateOtpRequestDto;
import com.gdc.user_auth_service.dto.request.VerifyOtpRequestDto;
import com.gdc.user_auth_service.dto.response.GenerateOtpResponseDto;
import com.gdc.user_auth_service.dto.response.VerifyOtpResponseDto;

public interface OtpService {
    GenerateOtpResponseDto generateOtp(GenerateOtpRequestDto request);
    VerifyOtpResponseDto verifyOtp(VerifyOtpRequestDto request);

}
