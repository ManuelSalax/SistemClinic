package com.sistemclinc.sistemclinc.Domain.model.Inventario;

public class Procedimiento {

    private Long id;
    private String nombre;
    private double costo;

    public Procedimiento(Long id, String nombre, double costo) {
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

    // (Opcional) Setter si necesitas modificar datos desde el dominio
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}