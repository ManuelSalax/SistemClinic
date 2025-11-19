package com.sistemclinc.sistemclinc.Application.UseCase.Patient;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.PatientRepository;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;

@Service
public class GetPatientByIdUseCase {

    private final PatientRepository repository;

    public GetPatientByIdUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient execute(Long id) {
        return repository.findById(id);
    }
}