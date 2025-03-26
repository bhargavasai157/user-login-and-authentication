package com.gdc.user_auth_service.controller;

import com.gdc.user_auth_service.dto.request.GenerateOtpRequestDto;
import com.gdc.user_auth_service.dto.request.VerifyOtpRequestDto;
import com.gdc.user_auth_service.dto.response.GenerateOtpResponseDto;
import com.gdc.user_auth_service.dto.response.VerifyOtpResponseDto;
import com.gdc.user_auth_service.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/otp")
@RequiredArgsConstructor
public class OtpController {
    private final OtpService otpService;

    @PostMapping("/generate")
    public ResponseEntity<GenerateOtpResponseDto>generateOtp(@RequestBody GenerateOtpRequestDto requestDto){
        GenerateOtpResponseDto response = otpService.generateOtp(requestDto);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/verify")
    public ResponseEntity<VerifyOtpResponseDto> verifyOtp(@RequestBody VerifyOtpRequestDto request) {
        VerifyOtpResponseDto response = otpService.verifyOtp(request);
        return ResponseEntity.ok(response);
    }

}
