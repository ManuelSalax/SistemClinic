package com.sistemclinc.sistemclinc.Application.UseCase.Medication;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
@Service
public class UpdateMedicationUseCase {

    private final MedicationRepository repository;

    public UpdateMedicationUseCase(MedicationRepository repository) {
        this.repository = repository;
    }

    public Medication execute(Long id, Medication updated) {

        Medication existing = repository.findById(id);
        if (existing == null)
            throw new RuntimeException("Medication not found");

        Medication medication = new Medication(
                id,
                updated.getName(),
                updated.getStock(),
                updated.getPrice()
        );

        return repository.save(medication);
    }
}