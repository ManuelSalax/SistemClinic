package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepositoryJpa extends JpaRepository<MedicationEntity, Long> {
}
