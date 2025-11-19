package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.PatientEntity;

public class PatientMapper {
    public static PatientEntity toPersistence(Patient patient) {
        if (patient == null) return null;
        PatientEntity entity = new PatientEntity();
        entity.setName(patient.getName());
        entity.setLastName(patient.getLastName());
        entity.setDocument(patient.getDocument());
        entity.setBirthDate(patient.getBirthDate());
        entity.setPhone(patient.getPhone());
        entity.setAddress(patient.getAddress());
        return entity;
    }

    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) return null;
        return new Patient(
            entity.getId(),
            entity.getName(),
            entity.getLastName(),
            entity.getDocument(),
            entity.getBirthDate(),
            entity.getPhone(),
            entity.getAddress()
        );
    }
}
