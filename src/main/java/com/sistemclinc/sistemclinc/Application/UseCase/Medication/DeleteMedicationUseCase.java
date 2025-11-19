package com.sistemclinc.sistemclinc.Application.UseCase.Medication;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationRepository;
@Service
public class DeleteMedicationUseCase {

    private final MedicationRepository repository;

    public DeleteMedicationUseCase(MedicationRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}