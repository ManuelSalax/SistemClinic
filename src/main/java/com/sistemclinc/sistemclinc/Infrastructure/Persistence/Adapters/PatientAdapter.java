package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.PatientRepository;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.PatientEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.PatientMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.PatientRepositoryJpa;

@Repository
public class PatientAdapter implements PatientRepository {

    private final PatientRepositoryJpa jpa;

    public PatientAdapter(PatientRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Patient save(Patient patient) {
        PatientEntity entity = PatientMapper.toPersistence(patient);
        PatientEntity saved = jpa.save(entity);
        return PatientMapper.toDomain(saved);
    }

    @Override
    public Patient findById(Long id) {
        return jpa.findById(id)
                .map(PatientMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Patient> findAll() {
        return jpa.findAll().stream()
                .map(PatientMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
