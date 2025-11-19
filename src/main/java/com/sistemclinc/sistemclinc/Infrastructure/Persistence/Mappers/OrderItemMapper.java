package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import java.math.BigDecimal;

import com.sistemclinc.sistemclinc.Domain.model.Order.OrderItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;

public class OrderItemMapper {

    /**
     * Convierte OrderItem (dominio) → OrderItemEntity (JPA)
     */
    public static OrderItemEntity toPersistence(OrderItem item, OrderEntity orderEntity) {
        if (item == null || orderEntity == null) return null;

        OrderItemEntity entity = new OrderItemEntity();

        entity.setName(item.getName());
        entity.setCost(BigDecimal.valueOf(item.calculateCost())); // ✔ costo REAL
        entity.setOrder(orderEntity);

        return entity;
    }

    /**
     * No hacemos toDomain aquí para evitar romper subclasses.
     * Cada mapper específico (Medication/Procedure/DiagnosticAid) lo resuelve.
     */
}
