package com.sistemclinc.sistemclinc.Domain.model.Order;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;

public class DiagnosticAidItem extends OrderItem {

    private DiagnosticAid diagnosticAid;

    public DiagnosticAidItem(Long id,Long orderId, String name, double cost, DiagnosticAid diagnosticAid) {
        super(id,orderId, name, cost);
        this.diagnosticAid = diagnosticAid;
    }

    public DiagnosticAid getDiagnosticAid() {
        return diagnosticAid;
    }

    public void setDiagnosticAid(DiagnosticAid diagnosticAid) {
        this.diagnosticAid = diagnosticAid;
    }

    @Override
    public double calculateCost() {
        return diagnosticAid.getCost();
    }

    @Override
    public String toString() {
        return "DiagnosticAidItem{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", cost=" + getCost() +
                ", diagnosticAid=" + (diagnosticAid != null ? diagnosticAid.getName() : "null") +
                '}';
    }
}
