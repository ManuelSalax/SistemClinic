package com.sistemclinc.sistemclinc.Domain.model.Inventario;

public class AyudaDiagnostica {

    private Long id;
    private String nombre;
    private double costo;

    public AyudaDiagnostica(Long id, String nombre, double costo) {
        this.id = id;
        this.nombre = nombre;
        this.costo = costo;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    // Setters opcionales
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
