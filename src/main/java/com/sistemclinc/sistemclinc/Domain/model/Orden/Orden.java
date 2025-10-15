package com.sistemclinc.sistemclinc.Domain.model.Orden;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Empleado.Empleado;
import com.sistemclinc.sistemclinc.Domain.model.Paciente.Paciente;

public class Orden {

    private Long id;
    private Paciente paciente;
    private Empleado medico;
    private final LocalDateTime fecha;
    private List<ItemOrden> items;

    public Orden(Long id, Paciente paciente, Empleado medico) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemOrden item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        return items.stream().mapToDouble(ItemOrden::getCosto).sum();
    }
}
