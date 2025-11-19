package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidItemEntity;

public interface DiagnosticAidItemRepositoryJpa extends JpaRepository<DiagnosticAidItemEntity, Long> {

    Optional<DiagnosticAidItemEntity> findByItem_Id(Long orderItemId);

}
