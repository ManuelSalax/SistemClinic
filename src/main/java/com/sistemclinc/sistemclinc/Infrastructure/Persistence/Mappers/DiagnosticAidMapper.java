package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidEntity;

public class DiagnosticAidMapper {
    public static DiagnosticAidEntity toPersistence(DiagnosticAid aid) {
        if (aid == null) return null;
        DiagnosticAidEntity entity = new DiagnosticAidEntity();
        entity.setName(aid.getName());
        entity.setCost(aid.getCost());
        return entity;
    }

    public static DiagnosticAid toDomain(DiagnosticAidEntity entity) {
        if (entity == null) return null;
        return new DiagnosticAid(
            entity.getId(),
            entity.getName(),
            entity.getCost()
        );
    }
}
