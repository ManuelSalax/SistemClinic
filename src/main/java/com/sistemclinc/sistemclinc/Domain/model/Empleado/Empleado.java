package com.sistemclinc.sistemclinc.Domain.model.Empleado;

import java.util.Objects;

public class Empleado {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String cargo;
    private String especialidad;
    private double salario;

    public Empleado(Long id, String nombre, String apellido, String email, String telefono,
                    String cargo, String especialidad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.cargo = cargo;
        this.especialidad = especialidad;
        this.salario = salario;
    }

    public Empleado(String nombre, String apellido, String email, String telefono,
                    String cargo, String especialidad, double salario) {
        this(null, nombre, apellido, email, telefono, cargo, especialidad, salario);
    }

    // getters/setters y lógica
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void aumentarSalario(double porcentaje) {
        if (porcentaje <= 0) throw new IllegalArgumentException("Porcentaje inválido");
        this.salario += this.salario * (porcentaje / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empleado)) return false;
        return Objects.equals(id, ((Empleado) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
