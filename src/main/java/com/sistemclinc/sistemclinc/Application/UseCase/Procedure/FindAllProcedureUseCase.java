package com.sistemclinc.sistemclinc.Application.UseCase.Procedure;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;
@Service
public class FindAllProcedureUseCase {

    private final ProcedureRepository repository;

    public FindAllProcedureUseCase(ProcedureRepository repository) {
        this.repository = repository;
    }

    public List<Procedure> execute() {
        return repository.findAll();
    }
}
