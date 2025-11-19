package com.sistemclinc.sistemclinc.Domain.model.Inventory;

public class Medication {

    private Long id;
    private String name;
    private int stock;
    private double price;

    public Medication(Long id, String name, int stock, double price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock) throw new IllegalArgumentException("Insufficient stock");
        this.stock -= quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
