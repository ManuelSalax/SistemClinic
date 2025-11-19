package com.sistemclinc.sistemclinc.Application.UseCase.Employee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.EmployeeRepository;
import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;

@Service

public class GetAllEmployeesUseCase {

    private final EmployeeRepository repository;

    public GetAllEmployeesUseCase(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> execute() {
        return repository.findAll();
    }
}
