package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepositoryJpa extends JpaRepository<ProcedureEntity, Long> {
}
