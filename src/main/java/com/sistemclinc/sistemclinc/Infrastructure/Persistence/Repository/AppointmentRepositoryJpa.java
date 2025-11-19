package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.AppointmentEntity;

public interface AppointmentRepositoryJpa extends JpaRepository<AppointmentEntity, Long> {
}
