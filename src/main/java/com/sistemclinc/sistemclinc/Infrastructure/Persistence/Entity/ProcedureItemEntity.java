package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "procedure_items")
public class ProcedureItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItemEntity item;

    @ManyToOne
    @JoinColumn(name = "procedure_id", nullable = false)
    private ProcedureEntity procedure;

    public Long getId() { return id; }

    public OrderItemEntity getItem() { return item; }
    public void setItem(OrderItemEntity item) { this.item = item; }

    public ProcedureEntity getProcedure() { return procedure; }
    public void setProcedure(ProcedureEntity procedure) { this.procedure = procedure; }
}
