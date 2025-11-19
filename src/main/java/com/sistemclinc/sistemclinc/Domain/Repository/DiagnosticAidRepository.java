package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;

public interface DiagnosticAidRepository {
    DiagnosticAid save(DiagnosticAid aid);
    DiagnosticAid findById(Long id);
    List<DiagnosticAid> findAll();
    void deleteById(Long id);
}
