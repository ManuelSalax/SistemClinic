package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.ProcedureItemMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.ProcedureItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.ProcedureRepositoryJpa;

@Repository
public class ProcedureItemAdapter implements ProcedureItemRepository {

    private final ProcedureItemRepositoryJpa jpa;
    private final OrderItemRepositoryJpa orderItemJpa;
    private final ProcedureRepositoryJpa procedureJpa;

    public ProcedureItemAdapter(
            ProcedureItemRepositoryJpa jpa,
            OrderItemRepositoryJpa orderItemJpa,
            ProcedureRepositoryJpa procedureJpa) {

        this.jpa = jpa;
        this.orderItemJpa = orderItemJpa;
        this.procedureJpa = procedureJpa;
    }

    @Override
    public ProcedureItem save(ProcedureItem item) {

        // 1. Buscar OrderItemEntity (ID del order-item)
        OrderItemEntity orderItemEntity = orderItemJpa.findById(item.getId())
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));

        // 2. Buscar ProcedureEntity con item.getProcedure().getId()
        ProcedureEntity procedureEntity = procedureJpa.findById(item.getProcedure().getId())
                .orElseThrow(() -> new RuntimeException("Procedure not found"));

        // 3. Convertir dominio → entidad SQL
        ProcedureItemEntity entity =
                ProcedureItemMapper.toPersistence(item, orderItemEntity, procedureEntity);

        // 4. Guardar
        jpa.save(entity);

        return item; // o ProcedureItemMapper.toDomain(entity)
    }

        @Override
        public ProcedureItem findById(Long id) {
        return jpa.findById(id)
                .map(entity -> {

                        OrderItemEntity item = entity.getItem();

                        // Buscar el ProcedureItemEntity correcto
                        ProcedureItemEntity procItem = jpa.findById(id)
                                .orElseThrow(() -> new RuntimeException("ProcedureItem not found"));

                        ProcedureEntity proc = procItem.getProcedure();

                        return new ProcedureItem(
                                item.getId(),                // itemId
                                item.getOrder().getId(),     // orderId
                                item.getName(),
                                item.getCost().doubleValue(),
                                new com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure(
                                        proc.getId(),
                                        proc.getName(),
                                        proc.getCost()
                                )
                        );
                })
                .orElse(null);
        }
}
