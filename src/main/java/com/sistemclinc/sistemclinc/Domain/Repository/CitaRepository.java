package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Cita.Cita;

public interface CitaRepository {
    Cita save(Cita cita);
    Optional<Cita> findById(Long id);
    List<Cita> findAll();
    void deleteById(Long id);
}
