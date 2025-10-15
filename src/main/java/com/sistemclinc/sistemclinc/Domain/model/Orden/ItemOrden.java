package com.sistemclinc.sistemclinc.Domain.model.Orden;

public abstract class ItemOrden {

    protected Long id;
    protected String nombre;
    protected double costo;

    public ItemOrden(Long id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public double getCosto() { return costo; }

    public void setCosto(double costo) { this.costo = costo; }

    public abstract double calcularCosto();
}
