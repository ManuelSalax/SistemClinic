package com.sistemclinc.sistemclinc.Application.UseCase.Employee;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.EmployeeRepository;
import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;

@Service
public class GetEmployeeByIdUseCase {

    private final EmployeeRepository repository;

    public GetEmployeeByIdUseCase(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee execute(Long id) {
        return repository.findById(id);
    }
}
