package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureItemEntity;

public class ProcedureItemMapper {

    /**
     * Convierte dominio → JPA
     */
    public static ProcedureItemEntity toPersistence(ProcedureItem item,
                                                    OrderItemEntity orderItemEntity,
                                                    ProcedureEntity procedureEntity) {

        if (item == null || orderItemEntity == null || procedureEntity == null) return null;

        ProcedureItemEntity entity = new ProcedureItemEntity();
        entity.setItem(orderItemEntity);
        entity.setProcedure(procedureEntity);

        return entity;
    }

    /**
     * Convierte JPA → dominio
     */
    public static ProcedureItem toDomain(ProcedureItemEntity entity) {
        if (entity == null) return null;

        OrderItemEntity item = entity.getItem();
        ProcedureEntity procedureEntity = entity.getProcedure();

        return new ProcedureItem(
                item.getId(),                      // id (order_item_id)
                item.getOrder().getId(),           // orderId (nuevo requerido)
                item.getName(),
                item.getCost().doubleValue(),
                new com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure(
                        procedureEntity.getId(),
                        procedureEntity.getName(),
                        procedureEntity.getCost()
                )
        );
    }
}
