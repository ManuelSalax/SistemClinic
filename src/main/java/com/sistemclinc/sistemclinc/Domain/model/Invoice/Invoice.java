package com.sistemclinc.sistemclinc.Domain.model.Invoice;

import java.time.LocalDateTime;

import com.sistemclinc.sistemclinc.Domain.model.Order.Order;

public class Invoice {

    private Long id;
    private Order order;
    private LocalDateTime date;
    private double total;

    public Invoice(Long id, Order order) {
        this.id = id;
        this.order = order;
        this.date = LocalDateTime.now();
        this.total = order.calculateTotal();
    }

    // ---------- GETTERS ----------
    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getTotal() {
        return total;
    }

    // ---------- SETTERS OPCIONALES (si los necesitas) ----------
    public void setId(Long id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
