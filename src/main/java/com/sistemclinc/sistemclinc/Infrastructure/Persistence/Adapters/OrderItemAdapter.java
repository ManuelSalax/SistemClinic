package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;
import com.sistemclinc.sistemclinc.Domain.model.Order.DefaultOrderItem;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;
import com.sistemclinc.sistemclinc.Domain.model.Order.OrderItem;
import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureItemEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.DiagnosticAidItemMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.DiagnosticAidMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.MedicationItemMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.MedicationMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.OrderItemMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.ProcedureItemMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.ProcedureMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.DiagnosticAidItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.DiagnosticAidRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.MedicationItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.MedicationRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.ProcedureItemRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.ProcedureRepositoryJpa;

@Repository
public class OrderItemAdapter implements OrderItemRepository {

    private final OrderItemRepositoryJpa jpa;
    private final OrderRepositoryJpa orderJpa;

    // repos de items concretos (ITEM → OrderItemEntity child)
    private final MedicationItemRepositoryJpa medicationItemJpa;
    private final DiagnosticAidItemRepositoryJpa diagnosticAidItemJpa;
    private final ProcedureItemRepositoryJpa procedureItemJpa;

    // repos de inventario real (MedicationEntity, DiagnosticAidEntity, ProcedureEntity)
    private final MedicationRepositoryJpa medicationRepo;
    private final DiagnosticAidRepositoryJpa diagnosticRepo;
    private final ProcedureRepositoryJpa procedureRepo;

    public OrderItemAdapter(
            OrderItemRepositoryJpa jpa,
            OrderRepositoryJpa orderJpa,
            MedicationItemRepositoryJpa medicationItemJpa,
            DiagnosticAidItemRepositoryJpa diagnosticAidItemJpa,
            ProcedureItemRepositoryJpa procedureItemJpa,
            MedicationRepositoryJpa medicationRepo,
            DiagnosticAidRepositoryJpa diagnosticRepo,
            ProcedureRepositoryJpa procedureRepo
    ) {
        this.jpa = jpa;
        this.orderJpa = orderJpa;
        this.medicationItemJpa = medicationItemJpa;
        this.diagnosticAidItemJpa = diagnosticAidItemJpa;
        this.procedureItemJpa = procedureItemJpa;

        this.medicationRepo = medicationRepo;
        this.diagnosticRepo = diagnosticRepo;
        this.procedureRepo = procedureRepo;
    }

    // ===============================================================
    // SAVE (Polimórfico según el tipo de OrderItem)
    // ===============================================================
    @Override
    public OrderItem save(OrderItem item) {

        // 1. Obtener la orden
        OrderEntity orderEntity = orderJpa.findById(item.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        // 2. Guardar entidad base OrderItemEntity
        OrderItemEntity baseEntity = OrderItemMapper.toPersistence(item, orderEntity);
        baseEntity = jpa.save(baseEntity);

        // =============================================================
        // MEDICATION ITEM
        // =============================================================
        if (item instanceof MedicationItem medItem) {

            MedicationEntity med = medicationRepo.findById(
                    medItem.getMedication().getId()
            ).orElseThrow(() -> new RuntimeException("Medication not found"));

            MedicationItemEntity entity =
                    MedicationItemMapper.toPersistence(medItem, baseEntity, med);

            medicationItemJpa.save(entity);
        }

        // =============================================================
        // DIAGNOSTIC AID ITEM
        // =============================================================
        else if (item instanceof DiagnosticAidItem aidItem) {

            DiagnosticAidEntity aid = diagnosticRepo.findById(
                    aidItem.getDiagnosticAid().getId()
            ).orElseThrow(() -> new RuntimeException("Diagnostic Aid not found"));

            DiagnosticAidItemEntity entity =
                    DiagnosticAidItemMapper.toPersistence(aidItem, baseEntity, aid);

            diagnosticAidItemJpa.save(entity);
        }

        // =============================================================
        // PROCEDURE ITEM
        // =============================================================
        else if (item instanceof ProcedureItem procItem) {

            ProcedureEntity proc = procedureRepo.findById(
                    procItem.getProcedure().getId()
            ).orElseThrow(() -> new RuntimeException("Procedure not found"));

            ProcedureItemEntity entity =
                    ProcedureItemMapper.toPersistence(procItem, baseEntity, proc);

            procedureItemJpa.save(entity);
        }

        return item;
    }

    // ===============================================================
    // FIND BY ORDER ID (Polimórfico)
    // ===============================================================
    @Override
    public List<OrderItem> findByOrderId(Long orderId) {

        List<OrderItemEntity> items = jpa.findByOrderId(orderId);

        return items.stream().map(itemEntity -> {

            Long itemId = itemEntity.getId();
            String name = itemEntity.getName();
            double cost = itemEntity.getCost().doubleValue();
            Long orderIdValue = itemEntity.getOrder().getId();

            // ---------------------------------------------------------
            // 1) MedicationItem
            // ---------------------------------------------------------
            MedicationItemEntity medEntity = medicationItemJpa.findByItem_Id(itemId).orElse(null);
            if (medEntity != null) {

                MedicationEntity med = medEntity.getMedication();
                Medication medication = MedicationMapper.toDomain(med);

                return new MedicationItem(
                        itemId,
                        orderIdValue,
                        name,
                        cost,
                        medication,
                        medEntity.getQuantity()
                );
            }

            // ---------------------------------------------------------
            // 2) DiagnosticAidItem
            // ---------------------------------------------------------
            DiagnosticAidItemEntity aidEntity = diagnosticAidItemJpa.findByItem_Id(itemId).orElse(null);
            if (aidEntity != null) {

                DiagnosticAidEntity diag = aidEntity.getDiagnosticAid();
                DiagnosticAid diagnosticAid = DiagnosticAidMapper.toDomain(diag);

                return new DiagnosticAidItem(
                        itemId,
                        orderIdValue,
                        name,
                        cost,
                        diagnosticAid
                );
            }

            // ---------------------------------------------------------
            // 3) ProcedureItem
            // ---------------------------------------------------------
            ProcedureItemEntity procEntity = procedureItemJpa.findByItem_Id(itemId).orElse(null);
            if (procEntity != null) {

                ProcedureEntity proc = procEntity.getProcedure();
                Procedure procedure = ProcedureMapper.toDomain(proc);

                return new ProcedureItem(
                        itemId,
                        orderIdValue,
                        name,
                        cost,
                        procedure
                );
            }

            // ---------------------------------------------------------
            // 4) Si no coincide → DefaultOrderItem
            // ---------------------------------------------------------
            return new DefaultOrderItem(
                    itemId,
                    orderIdValue,
                    name,
                    cost
            );

        }).toList();
    }
}
