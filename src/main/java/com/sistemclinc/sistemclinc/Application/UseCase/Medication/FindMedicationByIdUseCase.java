package com.sistemclinc.sistemclinc.Application.UseCase.Medication;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
@Service
public class FindMedicationByIdUseCase {

    private final MedicationRepository repository;

    public FindMedicationByIdUseCase(MedicationRepository repository) {
        this.repository = repository;
    }

    public Medication execute(Long id) {
        return repository.findById(id);
    }
}
