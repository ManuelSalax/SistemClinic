package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Orden.Orden;

public interface OrdenRepository {

    Orden save(Orden orden);
    Optional<Orden> findById(Long id);
    List<Orden> findAll();
    void deleteById(Long id);
}
