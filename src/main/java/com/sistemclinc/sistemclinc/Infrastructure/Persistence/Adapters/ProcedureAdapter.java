package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.ProcedureRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.Procedure;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.ProcedureEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.ProcedureMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.ProcedureRepositoryJpa;

@Repository
public class ProcedureAdapter implements ProcedureRepository {

    private final ProcedureRepositoryJpa jpa;

    public ProcedureAdapter(ProcedureRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Procedure save(Procedure procedure) {
        ProcedureEntity entity = ProcedureMapper.toPersistence(procedure);
        ProcedureEntity saved = jpa.save(entity);
        return ProcedureMapper.toDomain(saved);
    }

    @Override
    public Procedure findById(Long id) {
        return jpa.findById(id)
                .map(ProcedureMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Procedure> findAll() {
        return jpa.findAll()
                .stream()
                .map(ProcedureMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
