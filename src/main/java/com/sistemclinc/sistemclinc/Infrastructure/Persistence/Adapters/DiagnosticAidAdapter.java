package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.DiagnosticAidRepository;
import com.sistemclinc.sistemclinc.Domain.model.Inventory.DiagnosticAid;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.DiagnosticAidEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.DiagnosticAidMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.DiagnosticAidRepositoryJpa;

@Repository
public class DiagnosticAidAdapter implements DiagnosticAidRepository {

    private final DiagnosticAidRepositoryJpa jpa;

    public DiagnosticAidAdapter(DiagnosticAidRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public DiagnosticAid save(DiagnosticAid diagnosticAid) {
        DiagnosticAidEntity entity = DiagnosticAidMapper.toPersistence(diagnosticAid);
        DiagnosticAidEntity saved = jpa.save(entity);
        return DiagnosticAidMapper.toDomain(saved);
    }

    @Override
    public DiagnosticAid findById(Long id) {
        return jpa.findById(id)
                .map(DiagnosticAidMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<DiagnosticAid> findAll() {
        return jpa.findAll()
                .stream()
                .map(DiagnosticAidMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
