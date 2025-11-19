package com.sistemclinc.sistemclinc.Application.UseCase.Procedure;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;

@Service
public class UpdateProcedureUseCase {

    private final ProcedureRepository repository;

    public UpdateProcedureUseCase(ProcedureRepository repository) {
        this.repository = repository;
    }

    public Procedure execute(Long id, Procedure updated) {

        Procedure existing = repository.findById(id);
        if (existing == null)
            throw new RuntimeException("Procedure not found");

        Procedure procedure = new Procedure(
                id,
                updated.getName(),
                updated.getCost()
        );

        return repository.save(procedure);
    }
}