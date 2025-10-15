package com.sistemclinc.sistemclinc.Domain.model.Inventario;

public class Medicamento {

    private Long id;
    private String nombre;
    private int stock;
    private double precio;

    public Medicamento(Long id, String nombre, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public void reducirStock(int cantidad) {
        if (cantidad > stock) throw new IllegalArgumentException("Stock insuficiente");
        this.stock -= cantidad;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    // (Opcional) Setter para ajustar stock desde el dominio si lo necesitas
    public void setStock(int stock) {
        this.stock = stock;
    }
}
