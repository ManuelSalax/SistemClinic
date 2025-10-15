package com.sistemclinc.sistemclinc.Domain.model.Factura;

import java.time.LocalDateTime;

import com.sistemclinc.sistemclinc.Domain.model.Orden.Orden;

public class Factura {

    private Long id;
    private Orden orden;
    private LocalDateTime fecha;
    private double total;

    public Factura(Long id, Orden orden) {
        this.id = id;
        this.orden = orden;
        this.fecha = LocalDateTime.now();
        this.total = orden.calcularTotal();
    }
}
