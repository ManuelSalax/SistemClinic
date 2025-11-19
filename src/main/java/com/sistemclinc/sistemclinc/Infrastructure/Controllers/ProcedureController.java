package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.Procedure.CreateProcedureUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Procedure.DeleteProcedureUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Procedure.FindAllProcedureUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Procedure.FindProcedureByIdUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Procedure.UpdateProcedureUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;

@RestController
@RequestMapping("/api/procedures")
public class ProcedureController {

    private final CreateProcedureUseCase createUseCase;
    private final UpdateProcedureUseCase updateUseCase;
    private final FindProcedureByIdUseCase findByIdUseCase;
    private final FindAllProcedureUseCase findAllUseCase;
    private final DeleteProcedureUseCase deleteUseCase;

    public ProcedureController(CreateProcedureUseCase createUseCase,
                               UpdateProcedureUseCase updateUseCase,
                               FindProcedureByIdUseCase findByIdUseCase,
                               FindAllProcedureUseCase findAllUseCase,
                               DeleteProcedureUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.findAllUseCase = findAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public Procedure create(@RequestBody Procedure procedure) {
        return createUseCase.execute(procedure);
    }

    @GetMapping("/{id}")
    public Procedure findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }

    @GetMapping
    public List<Procedure> findAll() {
        return findAllUseCase.execute();
    }

    @PutMapping("/{id}")
    public Procedure update(@PathVariable Long id, @RequestBody Procedure procedure) {
        return updateUseCase.execute(id, procedure);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
    }
}
