package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.InvoiceEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderEntity;
import java.math.BigDecimal;

public class InvoiceMapper {
    public static InvoiceEntity toPersistence(Invoice invoice, OrderEntity orderEntity) {
        if (invoice == null || orderEntity == null) return null;
        InvoiceEntity entity = new InvoiceEntity();
        entity.setOrder(orderEntity);
        entity.setDate(invoice.getDate());
        entity.setTotal(BigDecimal.valueOf(invoice.getTotal()));
        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity, Order order) {
        if (entity == null || order == null) return null;
        return new Invoice(
            entity.getId(),
            order
        );
    }
}
