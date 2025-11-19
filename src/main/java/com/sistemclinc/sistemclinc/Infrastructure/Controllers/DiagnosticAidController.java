package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import com.sistemclinc.sistemclinc.Application.UseCase.DiagnosticAid.*;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnostic-aids")
public class DiagnosticAidController {

    private final CreateDiagnosticAidUseCase createUseCase;
    private final UpdateDiagnosticAidUseCase updateUseCase;
    private final FindDiagnosticAidByIdUseCase findByIdUseCase;
    private final FindAllDiagnosticAidUseCase findAllUseCase;
    private final DeleteDiagnosticAidUseCase deleteUseCase;

    public DiagnosticAidController(CreateDiagnosticAidUseCase createUseCase,
                                   UpdateDiagnosticAidUseCase updateUseCase,
                                   FindDiagnosticAidByIdUseCase findByIdUseCase,
                                   FindAllDiagnosticAidUseCase findAllUseCase,
                                   DeleteDiagnosticAidUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.findAllUseCase = findAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public DiagnosticAid create(@RequestBody DiagnosticAid aid) {
        return createUseCase.execute(aid);
    }

    @GetMapping("/{id}")
    public DiagnosticAid findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }

    @GetMapping
    public List<DiagnosticAid> findAll() {
        return findAllUseCase.execute();
    }

    @PutMapping("/{id}")
    public DiagnosticAid update(@PathVariable Long id, @RequestBody DiagnosticAid aid) {
        return updateUseCase.execute(id, aid);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
    }
}