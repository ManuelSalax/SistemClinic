package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureEntity;

public class ProcedureMapper {
    public static ProcedureEntity toPersistence(Procedure procedure) {
        if (procedure == null) return null;
        ProcedureEntity entity = new ProcedureEntity();
        entity.setName(procedure.getName());
        entity.setCost(procedure.getCost());
        return entity;
    }

    public static Procedure toDomain(ProcedureEntity entity) {
        if (entity == null) return null;
        return new Procedure(
            entity.getId(),
            entity.getName(),
            entity.getCost()
        );
    }
}
