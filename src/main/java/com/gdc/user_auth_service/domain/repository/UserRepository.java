package com.gdc.user_auth_service.domain.repository;

import com.gdc.user_auth_service.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User>findByPhone(String phone);
    Optional<User>findByEmail(String email);

}
