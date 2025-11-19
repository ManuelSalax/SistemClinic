package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.MedicationItemMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.MedicationItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.MedicationRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderItemRepositoryJpa;

@Repository
public class MedicationItemAdapter implements MedicationItemRepository {

    private final MedicationItemRepositoryJpa jpa;
    private final OrderItemRepositoryJpa orderItemJpa;
    private final MedicationRepositoryJpa medicationJpa;

    public MedicationItemAdapter(
            MedicationItemRepositoryJpa jpa,
            OrderItemRepositoryJpa orderItemJpa,
            MedicationRepositoryJpa medicationJpa) {

        this.jpa = jpa;
        this.orderItemJpa = orderItemJpa;
        this.medicationJpa = medicationJpa;
    }

    @Override
    public MedicationItem save(MedicationItem item) {

    // 1. Cargar OrderItemEntity (id = id del OrderItem)
    OrderItemEntity orderItemEntity = orderItemJpa.findById(item.getId())
            .orElseThrow(() -> new RuntimeException("OrderItem not found"));

    // 2. Cargar MedicationEntity con item.getMedication().getId()
    MedicationEntity medicationEntity = medicationJpa.findById(item.getMedication().getId())
            .orElseThrow(() -> new RuntimeException("Medication not found"));

    // 3. Convertir dominio → entidad (con los tres parámetros correctos)
    MedicationItemEntity entity =
            MedicationItemMapper.toPersistence(item, orderItemEntity, medicationEntity);

    // 4. Guardar
    jpa.save(entity);

    return item; // opcional: puedes devolver mapper.toDomain(entity)
    }

        @Override
        public MedicationItem findById(Long id) {
        return jpa.findById(id)
                .map(entity -> {

                        OrderItemEntity item = entity.getItem();
                        MedicationEntity med = entity.getMedication(); // ← CORRECTO

                        return new MedicationItem(
                                item.getId(),                  // id del item
                                item.getOrder().getId(),       // orderId (NUEVO)
                                item.getName(),
                                item.getCost().doubleValue(),
                                new com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication(
                                        med.getId(),
                                        med.getName(),
                                        med.getStock(),
                                        med.getPrice()
                                ),
                                entity.getQuantity()
                        );
                })
                .orElse(null);
        }
}
