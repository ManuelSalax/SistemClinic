package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;

@Service
public class FindDiagnosticAidItemByIdUseCase {

    private final DiagnosticAidItemRepository repository;

    public FindDiagnosticAidItemByIdUseCase(DiagnosticAidItemRepository repository) {
        this.repository = repository;
    }

    public DiagnosticAidItem execute(Long id) {
        return repository.findById(id);
    }
}