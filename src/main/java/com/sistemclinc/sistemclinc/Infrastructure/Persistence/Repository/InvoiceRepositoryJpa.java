package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepositoryJpa extends JpaRepository<InvoiceEntity, Long> {
}
