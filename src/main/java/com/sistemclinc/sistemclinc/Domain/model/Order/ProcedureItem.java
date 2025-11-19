package com.sistemclinc.sistemclinc.Domain.model.Order;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;

public class ProcedureItem extends OrderItem {

    private Procedure procedure;

    public ProcedureItem(Long id,Long orderId, String name, double cost, Procedure procedure) {
        super(id,orderId, name, cost);
        this.procedure = procedure;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    @Override
    public double calculateCost() {
        return procedure.getCost();
    }
}
