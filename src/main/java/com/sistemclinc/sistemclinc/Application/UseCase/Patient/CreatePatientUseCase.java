package com.sistemclinc.sistemclinc.Application.UseCase.Patient;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.PatientRepository;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
@Service
public class CreatePatientUseCase {

    private final PatientRepository repository;

    public CreatePatientUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient execute(Patient patient) {
        return repository.save(patient);
    }
}
