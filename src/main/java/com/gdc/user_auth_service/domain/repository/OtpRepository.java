package com.gdc.user_auth_service.domain.repository;

import com.gdc.user_auth_service.domain.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OtpRepository extends JpaRepository<Otp, UUID> {
    Optional<Otp> findByUserIdAndOtp(UUID userId, String otp);
    Optional<Otp> findByUserPhoneAndOtp(String phone, String otp);

}
