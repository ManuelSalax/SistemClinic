package com.sistemclinc.sistemclinc.Application.UseCase.DiagnosticAid;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;
@Service
public class CreateDiagnosticAidUseCase {

    private final DiagnosticAidRepository repository;

    public CreateDiagnosticAidUseCase(DiagnosticAidRepository repository) {
        this.repository = repository;
    }

    public DiagnosticAid execute(DiagnosticAid diagnosticAid) {
        return repository.save(diagnosticAid);
    }
}