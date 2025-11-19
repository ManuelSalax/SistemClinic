package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import com.sistemclinc.sistemclinc.Domain.Repository.EmployeeRepository;
import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.EmployeeMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.EmployeeRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeAdapter implements EmployeeRepository {

    private final EmployeeRepositoryJpa jpa;

    public EmployeeAdapter(EmployeeRepositoryJpa jpa) {
        this.jpa = jpa;
    }

    @Override
    public Employee save(Employee employee) {
        EmployeeEntity entity = EmployeeMapper.toPersistence(employee);
        EmployeeEntity saved = jpa.save(entity);
        return EmployeeMapper.toDomain(saved);
    }

    @Override
    public Employee findById(Long id) {
        return jpa.findById(id)
                .map(EmployeeMapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<Employee> findAll() {
        return jpa.findAll().stream()
                .map(EmployeeMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
