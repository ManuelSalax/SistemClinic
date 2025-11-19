package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositoryJpa extends JpaRepository<EmployeeEntity, Long> {
}
