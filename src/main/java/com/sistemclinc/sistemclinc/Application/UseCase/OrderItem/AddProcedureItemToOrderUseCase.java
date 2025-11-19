package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;

@Service
public class AddProcedureItemToOrderUseCase {

    private final OrderItemRepository repository;

    public AddProcedureItemToOrderUseCase(OrderItemRepository repository) {
        this.repository = repository;
    }

    public ProcedureItem execute(ProcedureItem item) {
        return (ProcedureItem) repository.save(item);
    }
}