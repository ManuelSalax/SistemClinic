package com.sistemclinc.sistemclinc.Domain.model.Order;

public abstract class OrderItem {

    protected Long id;        // ID del item
    protected Long orderId;   // ID de la orden (NECESARIO)
    protected String name;
    protected double cost;

    public OrderItem(Long id, Long orderId, String name, double cost) {
        this.id = id;
        this.orderId = orderId;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() { return id; }

    public Long getOrderId() { return orderId; }

    public String getName() { return name; }

    public double getCost() { return cost; }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Costo específico según el tipo (producto, procedimiento, medicamento…)
     */
    public abstract double calculateCost();
}
