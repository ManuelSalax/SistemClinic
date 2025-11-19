package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.Employee.CreateEmployeeUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Employee.DeleteEmployeeUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Employee.GetAllEmployeesUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Employee.GetEmployeeByIdUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Employee.UpdateEmployeeUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final CreateEmployeeUseCase createEmployee;
    private final GetEmployeeByIdUseCase getEmployeeById;
    private final GetAllEmployeesUseCase getAllEmployees;
    private final UpdateEmployeeUseCase updateEmployee;
    private final DeleteEmployeeUseCase deleteEmployee;

    public EmployeeController(
            CreateEmployeeUseCase createEmployee,
            GetEmployeeByIdUseCase getEmployeeById,
            GetAllEmployeesUseCase getAllEmployees,
            UpdateEmployeeUseCase updateEmployee,
            DeleteEmployeeUseCase deleteEmployee
    ) {
        this.createEmployee = createEmployee;
        this.getEmployeeById = getEmployeeById;
        this.getAllEmployees = getAllEmployees;
        this.updateEmployee = updateEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return createEmployee.execute(employee);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return getEmployeeById.execute(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return getAllEmployees.execute();
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return updateEmployee.execute(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteEmployee.execute(id);
    }
}
