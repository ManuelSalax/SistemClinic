package com.sistemclinc.sistemclinc.Application.UseCase.Medication;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
@Service
public class FindAllMedicationUseCase {

    private final MedicationRepository repository;

    public FindAllMedicationUseCase(MedicationRepository repository) {
        this.repository = repository;
    }

    public List<Medication> execute() {
        return repository.findAll();
    }
}
