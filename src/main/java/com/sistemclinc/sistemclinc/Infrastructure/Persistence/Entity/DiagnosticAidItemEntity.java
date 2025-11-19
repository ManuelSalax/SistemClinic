package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnostic_aid_items")
public class DiagnosticAidItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_item_id", nullable = false)
    private OrderItemEntity item;

    @ManyToOne
    @JoinColumn(name = "diagnostic_aid_id", nullable = false)
    private DiagnosticAidEntity diagnosticAid;

    public Long getId() { return id; }

    public OrderItemEntity getItem() { return item; }
    public void setItem(OrderItemEntity item) { this.item = item; }

    public DiagnosticAidEntity getDiagnosticAid() { return diagnosticAid; }
    public void setDiagnosticAid(DiagnosticAidEntity diagnosticAid) { this.diagnosticAid = diagnosticAid; }
}
