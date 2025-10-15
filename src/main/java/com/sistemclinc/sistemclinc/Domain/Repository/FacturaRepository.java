package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Factura.Factura;

public interface FacturaRepository {

    Factura save(Factura factura);
    Optional<Factura> findById(Long id);
    List<Factura> findAll();
    void deleteById(Long id);
}
