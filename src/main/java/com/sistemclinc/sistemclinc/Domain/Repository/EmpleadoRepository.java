package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Empleado.Empleado;

public interface EmpleadoRepository {

    Empleado save(Empleado empleado);
    Optional<Empleado> findById(Long id);
    List<Empleado> findAll();
    void deleteById(Long id);
}
