package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Paciente.Paciente;

public interface PacienteRepository {

    Paciente save(Paciente paciente);
    Optional<Paciente> findById(Long id);
    List<Paciente> findAll();
    void deleteById(Long id);
}
