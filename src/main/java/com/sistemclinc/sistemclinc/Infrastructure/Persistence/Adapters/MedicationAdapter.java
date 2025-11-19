package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.MedicationEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.MedicationMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.MedicationRepositoryJpa;

@Repository
public class MedicationAdapter implements MedicationRepository {

    private final MedicationRepositoryJpa jpa;

    public MedicationAdapter(MedicationRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Medication save(Medication medication) {
        MedicationEntity entity = MedicationMapper.toPersistence(medication);
        MedicationEntity saved = jpa.save(entity);
        return MedicationMapper.toDomain(saved);
    }

    @Override
    public Medication findById(Long id) {
        return jpa.findById(id)
                .map(MedicationMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Medication> findAll() {
        return jpa.findAll()
                .stream()
                .map(MedicationMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
