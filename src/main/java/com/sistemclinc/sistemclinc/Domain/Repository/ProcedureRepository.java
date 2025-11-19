package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;

public interface ProcedureRepository {
    Procedure save(Procedure procedure);
    Procedure findById(Long id);
    List<Procedure> findAll();
    void deleteById(Long id);
}
