package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosticAidRepositoryJpa extends JpaRepository<DiagnosticAidEntity, Long> {
}
