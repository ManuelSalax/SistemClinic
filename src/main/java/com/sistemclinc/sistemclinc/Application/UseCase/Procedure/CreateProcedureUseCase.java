package com.sistemclinc.sistemclinc.Application.UseCase.Procedure;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;
import  org.springframework.stereotype.Service;

@Service
public class CreateProcedureUseCase {

    private final ProcedureRepository repository;

    public CreateProcedureUseCase(ProcedureRepository repository) {
        this.repository = repository;
    }

    public Procedure execute(Procedure procedure) {
        return repository.save(procedure);
    }
}
