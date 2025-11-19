package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.UserEntity;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
