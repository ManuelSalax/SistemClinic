package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;

public interface MedicationRepository {
    Medication save(Medication medication);
    Medication findById(Long id);
    List<Medication> findAll();
    void deleteById(Long id);
}