package com.sistemclinc.sistemclinc.Application.UseCase.DiagnosticAid;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidRepository;
@Service
public class DeleteDiagnosticAidUseCase {

    private final DiagnosticAidRepository repository;

    public DeleteDiagnosticAidUseCase(DiagnosticAidRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
