package com.sistemclinc.sistemclinc.Domain.model.Orden;

import com.sistemclinc.sistemclinc.Domain.model.Inventario.AyudaDiagnostica;

public class AyudaDiagnosticaItem extends ItemOrden {

    private AyudaDiagnostica ayudaDiagnostica;

    public AyudaDiagnosticaItem(Long id, String nombre, double costo, AyudaDiagnostica ayudaDiagnostica) {
        super(id, nombre, costo);
        this.ayudaDiagnostica = ayudaDiagnostica;
    }

    public AyudaDiagnostica getAyudaDiagnostica() {
        return ayudaDiagnostica;
    }

    public void setAyudaDiagnostica(AyudaDiagnostica ayudaDiagnostica) {
        this.ayudaDiagnostica = ayudaDiagnostica;
    }

    @Override
    public double calcularCosto() {
        return ayudaDiagnostica.getCosto();
    }
}

