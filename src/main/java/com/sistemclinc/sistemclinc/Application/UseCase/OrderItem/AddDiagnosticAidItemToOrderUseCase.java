package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;

@Service
public class AddDiagnosticAidItemToOrderUseCase {

    private final OrderItemRepository repository;

    public AddDiagnosticAidItemToOrderUseCase(OrderItemRepository repository) {
        this.repository = repository;
    }

    public DiagnosticAidItem execute(DiagnosticAidItem item) {
        return (DiagnosticAidItem) repository.save(item);
    }
}