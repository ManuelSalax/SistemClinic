package com.sistemclinc.sistemclinc.Domain.model.Orden;

import com.sistemclinc.sistemclinc.Domain.model.Inventario.Procedimiento;

public class ProcedimientoItem extends ItemOrden {

    private Procedimiento procedimiento;

    public ProcedimientoItem(Long id, String nombre, double costo, Procedimiento procedimiento) {
        super(id, nombre, costo);
        this.procedimiento = procedimiento;
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Override
    public double calcularCosto() {
        return procedimiento.getCosto();
    }
}
