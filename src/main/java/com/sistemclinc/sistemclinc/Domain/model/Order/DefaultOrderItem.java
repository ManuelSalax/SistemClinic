package com.sistemclinc.sistemclinc.Domain.model.Order;

public class DefaultOrderItem extends OrderItem {

    public DefaultOrderItem(Long id,Long orderId, String name, double cost) {
        super(id,orderId, name, cost);
    }

    @Override
    public double calculateCost() {
        return this.cost;
    }
}