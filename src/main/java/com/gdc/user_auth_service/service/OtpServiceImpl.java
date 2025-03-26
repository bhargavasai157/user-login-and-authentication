package com.gdc.user_auth_service.service;

import com.gdc.user_auth_service.dto.request.GenerateOtpRequestDto;
import com.gdc.user_auth_service.dto.request.VerifyOtpRequestDto;
import com.gdc.user_auth_service.dto.response.GenerateOtpResponseDto;
import com.gdc.user_auth_service.dto.response.VerifyOtpResponseDto;
import com.gdc.user_auth_service.domain.entity.Otp;
import com.gdc.user_auth_service.domain.entity.User;
import com.gdc.user_auth_service.enums.OtpType;
import com.gdc.user_auth_service.exception.InvalidOtpException;
import com.gdc.user_auth_service.domain.repository.OtpRepository;
import com.gdc.user_auth_service.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService{
    private final OtpRepository otpRepository;
    private final UserRepository userRepository;

    @Override
    public GenerateOtpResponseDto generateOtp(GenerateOtpRequestDto request){
        User user = userRepository.findByPhone(request.getPhone())
                .orElseThrow(() -> new RuntimeException("User not found with phone: " + request.getPhone()));
        String otpCode = String.format("%06d", new Random().nextInt(999999));
        Timestamp expiresAt = Timestamp.from(Instant.now().plusSeconds(300));
        Otp otp = Otp.builder()
                .user(user)
                .otp(otpCode)
                .otpType(OtpType.REGISTER)
                .expiresAt(expiresAt)
                .createdAt(Timestamp.from(Instant.now()))
                .build();
        otpRepository.save(otp);

        return new GenerateOtpResponseDto("OTP generated successfully!", otpCode);
    }

    @Override
    public VerifyOtpResponseDto verifyOtp(VerifyOtpRequestDto request) {
        Optional<Otp> otpOptional = otpRepository.findByUserPhoneAndOtp(request.getPhone(), request.getOtp());

        if (otpOptional.isEmpty()) {
            throw new InvalidOtpException("Invalid OTP or OTP expired.");
        }

        Otp otp = otpOptional.get();
        if (otp.getExpiresAt().before(new Timestamp(System.currentTimeMillis()))) {
            throw new InvalidOtpException("OTP has expired.");
        }

        User user = otp.getUser();
        user.setIsVerified(true);
        userRepository.save(user);

        return new VerifyOtpResponseDto("OTP verified successfully!", user.getId());
    }

}
