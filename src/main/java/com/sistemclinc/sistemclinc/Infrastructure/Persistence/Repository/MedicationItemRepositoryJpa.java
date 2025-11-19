package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationItemEntity;

public interface MedicationItemRepositoryJpa extends JpaRepository<MedicationItemEntity, Long> {

    Optional<MedicationItemEntity> findByItem_Id(Long orderItemId);

}
