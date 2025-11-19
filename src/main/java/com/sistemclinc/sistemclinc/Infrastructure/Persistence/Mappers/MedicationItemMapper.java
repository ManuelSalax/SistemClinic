package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;

public class MedicationItemMapper {

    /**
     * Convierte dominio → entidad SQL
     */
    public static MedicationItemEntity toPersistence(MedicationItem item,
                                                     OrderItemEntity orderItemEntity,
                                                     MedicationEntity medicationEntity) {

        if (item == null || orderItemEntity == null || medicationEntity == null) return null;

        MedicationItemEntity entity = new MedicationItemEntity();
        entity.setItem(orderItemEntity);
        entity.setMedication(medicationEntity);
        entity.setQuantity(item.getQuantity());

        return entity;
    }

    /**
     * Convierte entidad SQL → dominio
     */
    public static MedicationItem toDomain(MedicationItemEntity entity) {
        if (entity == null) return null;

        MedicationEntity med = entity.getMedication();
        OrderItemEntity orderItem = entity.getItem();

        Medication medication = new Medication(
                med.getId(),
                med.getName(),
                med.getStock(),
                med.getPrice()
        );

        return new MedicationItem(
                orderItem.getId(),                    // itemId
                orderItem.getOrder().getId(),         // orderId (nuevo)
                orderItem.getName(),
                orderItem.getCost().doubleValue(),
                medication,
                entity.getQuantity()                  // int
        );
    }
}
