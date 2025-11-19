package com.sistemclinc.sistemclinc.Application.UseCase.Medication;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
@Service
public class CreateMedicationUseCase {

    private final MedicationRepository repository;

    public CreateMedicationUseCase(MedicationRepository repository) {
        this.repository = repository;
    }

    public Medication execute(Medication medication) {
        return repository.save(medication);
    }
}