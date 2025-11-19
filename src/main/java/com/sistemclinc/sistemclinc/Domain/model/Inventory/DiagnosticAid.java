package com.sistemclinc.sistemclinc.Domain.model.Inventory;

public class DiagnosticAid {

    private Long id;
    private String name;
    private double cost;

    public DiagnosticAid(Long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
