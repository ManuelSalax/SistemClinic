package com.sistemclinc.sistemclinc.Domain.model.Orden;

import com.sistemclinc.sistemclinc.Domain.model.Inventario.Medicamento;

public class MedicamentoItem extends ItemOrden {

    private Medicamento medicamento;
    private int cantidad;

    public MedicamentoItem(Long id, String nombre, double costo, Medicamento medicamento, int cantidad) {
        super(id, nombre, costo);
        this.medicamento = medicamento;
        this.cantidad = cantidad;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double calcularCosto() {
        return medicamento.getPrecio() * cantidad;
    }
}