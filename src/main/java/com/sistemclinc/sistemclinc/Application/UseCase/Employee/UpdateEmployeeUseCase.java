package com.sistemclinc.sistemclinc.Application.UseCase.Employee;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.EmployeeRepository;
import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;
@Service
public class UpdateEmployeeUseCase {

    private final EmployeeRepository repository;

    public UpdateEmployeeUseCase(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee execute(Employee employee) {
        return repository.save(employee);
    }
}
