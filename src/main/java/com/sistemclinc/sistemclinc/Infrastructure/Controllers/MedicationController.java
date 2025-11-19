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

import com.sistemclinc.sistemclinc.Application.UseCase.Medication.CreateMedicationUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Medication.DeleteMedicationUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Medication.FindAllMedicationUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Medication.FindMedicationByIdUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Medication.UpdateMedicationUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;

@RestController
@RequestMapping("/api/medications")
public class MedicationController {

    private final CreateMedicationUseCase createUseCase;
    private final UpdateMedicationUseCase updateUseCase;
    private final FindMedicationByIdUseCase findByIdUseCase;
    private final FindAllMedicationUseCase findAllUseCase;
    private final DeleteMedicationUseCase deleteUseCase;

    public MedicationController(CreateMedicationUseCase createUseCase,
                                UpdateMedicationUseCase updateUseCase,
                                FindMedicationByIdUseCase findByIdUseCase,
                                FindAllMedicationUseCase findAllUseCase,
                                DeleteMedicationUseCase deleteUseCase) {
        this.createUseCase = createUseCase;
        this.updateUseCase = updateUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.findAllUseCase = findAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    // -----------------------------
    // CREATE
    // -----------------------------
    @PostMapping
    public Medication create(@RequestBody Medication medication) {
        return createUseCase.execute(medication);
    }

    // -----------------------------
    // FIND BY ID
    // -----------------------------
    @GetMapping("/{id}")
    public Medication findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }

    // -----------------------------
    // FIND ALL
    // -----------------------------
    @GetMapping
    public List<Medication> findAll() {
        return findAllUseCase.execute();
    }

    // -----------------------------
    // UPDATE
    // -----------------------------
    @PutMapping("/{id}")
    public Medication update(@PathVariable Long id, @RequestBody Medication medication) {
        return updateUseCase.execute(id, medication);
    }

    // -----------------------------
    // DELETE
    // -----------------------------
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
    }
}
