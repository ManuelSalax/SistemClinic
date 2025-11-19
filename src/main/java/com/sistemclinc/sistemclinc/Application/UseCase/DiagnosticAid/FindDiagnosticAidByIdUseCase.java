package com.sistemclinc.sistemclinc.Application.UseCase.DiagnosticAid;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;

@Service
public class FindDiagnosticAidByIdUseCase {

    private final DiagnosticAidRepository repository;

    public FindDiagnosticAidByIdUseCase(DiagnosticAidRepository repository) {
        this.repository = repository;
    }

    public DiagnosticAid execute(Long id) {
        return repository.findById(id);
    }
}
