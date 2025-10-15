package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;
import java.util.Optional;

import com.sistemclinc.sistemclinc.Domain.model.Inventario.AyudaDiagnostica;
import com.sistemclinc.sistemclinc.Domain.model.Inventario.Medicamento;
import com.sistemclinc.sistemclinc.Domain.model.Inventario.Procedimiento;

public interface InventarioRepository {

    // Medicamentos
    Medicamento saveMedicamento(Medicamento medicamento);
    Optional<Medicamento> findMedicamentoById(Long id);
    List<Medicamento> findAllMedicamentos();
    void deleteMedicamento(Long id);

    // Procedimientos
    Procedimiento saveProcedimiento(Procedimiento procedimiento);
    Optional<Procedimiento> findProcedimientoById(Long id);
    List<Procedimiento> findAllProcedimientos();
    void deleteProcedimiento(Long id);

    // Ayudas Diagnósticas
    AyudaDiagnostica saveAyudaDiagnostica(AyudaDiagnostica ayuda);
    Optional<AyudaDiagnostica> findAyudaDiagnosticaById(Long id);
    List<AyudaDiagnostica> findAllAyudasDiagnosticas();
    void deleteAyudaDiagnostica(Long id);
}