package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;

public interface InventoryRepository {

    // Medications
    Medication saveMedication(Medication medication);
    Medication findMedicationById(Long id);
    List<Medication> findAllMedications();
    void deleteMedication(Long id);

    // Procedures
    Procedure saveProcedure(Procedure procedure);
    Procedure findProcedureById(Long id);
    List<Procedure> findAllProcedures();
    void deleteProcedure(Long id);

    // Diagnostic Aids
    DiagnosticAid saveDiagnosticAid(DiagnosticAid aid);
    DiagnosticAid findDiagnosticAidById(Long id);
    List<DiagnosticAid> findAllDiagnosticAids();
    void deleteDiagnosticAid(Long id);
}
