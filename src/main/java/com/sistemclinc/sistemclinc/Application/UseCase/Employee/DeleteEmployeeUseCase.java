package com.sistemclinc.sistemclinc.Application.UseCase.Employee;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.EmployeeRepository;
@Service
public class DeleteEmployeeUseCase {

    private final EmployeeRepository repository;

    public DeleteEmployeeUseCase(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}