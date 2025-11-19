package com.sistemclinc.sistemclinc.Application.UseCase.DiagnosticAid;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;

@Service
public class FindAllDiagnosticAidUseCase {

    private final DiagnosticAidRepository repository;

    public FindAllDiagnosticAidUseCase(DiagnosticAidRepository repository) {
        this.repository = repository;
    }

    public List<DiagnosticAid> execute() {
        return repository.findAll();
    }
}
