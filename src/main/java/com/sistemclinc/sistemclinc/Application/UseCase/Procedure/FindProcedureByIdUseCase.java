package com.sistemclinc.sistemclinc.Application.UseCase.Procedure;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;
@Service
public class FindProcedureByIdUseCase {

    private final ProcedureRepository repository;

    public FindProcedureByIdUseCase(ProcedureRepository repository) {
        this.repository = repository;
    }

    public Procedure execute(Long id) {
        return repository.findById(id);
    }
}