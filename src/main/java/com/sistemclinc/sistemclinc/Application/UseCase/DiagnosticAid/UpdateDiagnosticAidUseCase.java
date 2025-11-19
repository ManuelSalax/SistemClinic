package com.sistemclinc.sistemclinc.Application.UseCase.DiagnosticAid;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;

@Service
public class UpdateDiagnosticAidUseCase {

    private final DiagnosticAidRepository repository;

    public UpdateDiagnosticAidUseCase(DiagnosticAidRepository repository) {
        this.repository = repository;
    }

    public DiagnosticAid execute(Long id, DiagnosticAid updatedData) {

        DiagnosticAid existing = repository.findById(id);
        if (existing == null) {
            throw new RuntimeException("Diagnostic Aid not found with ID: " + id);
        }

        // Actualizar campos
        existing.setName(updatedData.getName());
        existing.setCost(updatedData.getCost());

        return repository.save(existing);
    }
}