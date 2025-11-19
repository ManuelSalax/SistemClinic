package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureItemEntity;

public interface ProcedureItemRepositoryJpa extends JpaRepository<ProcedureItemEntity, Long> {

    Optional<ProcedureItemEntity> findByItem_Id(Long orderItemId);

}