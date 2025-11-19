package com.sistemclinc.sistemclinc.Application.UseCase.Patient;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.PatientRepository;
@Service

public class DeletePatientUseCase {

    private final PatientRepository repository;

    public DeletePatientUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
