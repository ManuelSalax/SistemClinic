package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationEntity;

public class MedicationMapper {
    public static MedicationEntity toPersistence(Medication medication) {
        if (medication == null) return null;
        MedicationEntity entity = new MedicationEntity();
        entity.setName(medication.getName());
        entity.setStock(medication.getStock());
        entity.setPrice(medication.getPrice());
        return entity;
    }

    public static Medication toDomain(MedicationEntity entity) {
        if (entity == null) return null;
        return new Medication(
            entity.getId(),
            entity.getName(),
            entity.getStock(),
            entity.getPrice()
        );
    }
}
