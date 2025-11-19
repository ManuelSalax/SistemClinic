package com.sistemclinc.sistemclinc.Application.UseCase.Patient;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.PatientRepository;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
@Service

public class GetAllPatientsUseCase {

    private final PatientRepository repository;

    public GetAllPatientsUseCase(PatientRepository repository) {
        this.repository = repository;
    }

    public List<Patient> execute() {
        return repository.findAll();
    }
}