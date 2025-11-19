package com.sistemclinc.sistemclinc.Application.UseCase.Procedure;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureRepository;
import org.springframework.stereotype.Service;
@Service

public class DeleteProcedureUseCase {

    private final ProcedureRepository repository;

    public DeleteProcedureUseCase(ProcedureRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}

