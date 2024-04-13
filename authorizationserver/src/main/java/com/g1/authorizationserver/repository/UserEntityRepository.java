package com.g1.authorizationserver.repository;

import com.g1.authorizationserver.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

    Optional<UserEntity> findByEmail(String email);
}
