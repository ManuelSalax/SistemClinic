package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;
@Service
public class FindProcedureItemByIdUseCase {

    private final ProcedureItemRepository repository;

    public FindProcedureItemByIdUseCase(ProcedureItemRepository repository) {
        this.repository = repository;
    }

    public ProcedureItem execute(Long id) {
        return repository.findById(id);
    }
}