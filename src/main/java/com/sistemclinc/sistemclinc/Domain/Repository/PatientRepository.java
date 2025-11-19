package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;

public interface PatientRepository {

    Patient save(Patient patient);
    Patient findById(Long id);
    List<Patient> findAll();
    void deleteById(Long id);
}
