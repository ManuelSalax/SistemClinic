package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;

public class DiagnosticAidItemMapper {

    // Domain → Entity
    public static DiagnosticAidItemEntity toPersistence(DiagnosticAidItem item,
                                                        OrderItemEntity orderItemEntity,
                                                        DiagnosticAidEntity diagnosticAidEntity) {
        if (item == null || orderItemEntity == null || diagnosticAidEntity == null) return null;

        DiagnosticAidItemEntity entity = new DiagnosticAidItemEntity();
        entity.setItem(orderItemEntity);
        entity.setDiagnosticAid(diagnosticAidEntity);
        return entity;
    }

    // Entity → Domain
    public static DiagnosticAidItem toDomain(DiagnosticAidItemEntity entity) {
        if (entity == null) return null;

        OrderItemEntity orderItem = entity.getItem();

        DiagnosticAid diagnosticAid = new DiagnosticAid(
                entity.getDiagnosticAid().getId(),
                entity.getDiagnosticAid().getName(),
                entity.getDiagnosticAid().getCost()
        );

        return new DiagnosticAidItem(
                orderItem.getId(),                 // itemId
                orderItem.getOrder().getId(),      // orderId (nuevo)
                orderItem.getName(),
                orderItem.getCost().doubleValue(),
                diagnosticAid
        );
    }
}
