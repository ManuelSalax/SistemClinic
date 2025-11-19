package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;
@Service
public class CreateProcedureItemUseCase {

    private final ProcedureItemRepository repository;

    public CreateProcedureItemUseCase(ProcedureItemRepository repository) {
        this.repository = repository;
    }

    public ProcedureItem execute(ProcedureItem item) {
        return repository.save(item);
    }
}
