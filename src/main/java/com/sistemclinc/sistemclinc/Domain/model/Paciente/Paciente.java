package com.sistemclinc.sistemclinc.Domain.model.Paciente;

import java.time.LocalDate;
import java.util.Objects;

public class Paciente {

    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String direccion;

    public Paciente(Long id, String nombre, String apellido, String documento,
                    LocalDate fechaNacimiento, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int calcularEdad() {
        return LocalDate.now().getYear() - fechaNacimiento.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paciente)) return false;
        return Objects.equals(id, ((Paciente) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
