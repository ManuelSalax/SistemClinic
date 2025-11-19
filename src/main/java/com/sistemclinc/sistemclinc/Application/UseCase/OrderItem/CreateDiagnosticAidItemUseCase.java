package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;
@Service
public class CreateDiagnosticAidItemUseCase {

    private final DiagnosticAidItemRepository repository;

    public CreateDiagnosticAidItemUseCase(DiagnosticAidItemRepository repository) {
        this.repository = repository;
    }

    public DiagnosticAidItem execute(DiagnosticAidItem item) {
        return repository.save(item);
    }
}