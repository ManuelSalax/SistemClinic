package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.DiagnosticAidItemMapper;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.DiagnosticAidItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.DiagnosticAidRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderItemRepositoryJpa;

import org.springframework.stereotype.Repository;

@Repository
public class DiagnosticAidItemAdapter implements DiagnosticAidItemRepository {

    private final DiagnosticAidItemRepositoryJpa jpa;
    private final OrderItemRepositoryJpa orderItemJpa;
    private final DiagnosticAidRepositoryJpa diagnosticAidJpa;

    public DiagnosticAidItemAdapter(
            DiagnosticAidItemRepositoryJpa jpa,
            OrderItemRepositoryJpa orderItemJpa,
            DiagnosticAidRepositoryJpa diagnosticAidJpa) {

        this.jpa = jpa;
        this.orderItemJpa = orderItemJpa;
        this.diagnosticAidJpa = diagnosticAidJpa;
    }

    @Override
    public DiagnosticAidItem save(DiagnosticAidItem item) {

        OrderItemEntity orderItemEntity = orderItemJpa.findById(item.getId())
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        DiagnosticAidEntity diagnosticAidEntity = diagnosticAidJpa.findById(item.getDiagnosticAid().getId())
                .orElseThrow(() -> new RuntimeException("Diagnostic Aid not found"));

        DiagnosticAidItemEntity entity =
                DiagnosticAidItemMapper.toPersistence(item, orderItemEntity, diagnosticAidEntity);

        jpa.save(entity);

        return item;
    }

    @Override
    public DiagnosticAidItem findById(Long id) {
        return jpa.findById(id)
                .map(DiagnosticAidItemMapper::toDomain)
                .orElse(null);
    }
}