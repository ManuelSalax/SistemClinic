package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;
import java.math.BigDecimal;

public class EmployeeMapper {
    public static EmployeeEntity toPersistence(Employee employee) {
        if (employee == null) return null;
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employee.getName());
        entity.setLastName(employee.getLastName());
        entity.setEmail(employee.getEmail());
        entity.setPhone(employee.getPhone());
        entity.setPosition(employee.getPosition());
        entity.setSpecialty(employee.getSpecialty());
        entity.setSalary(BigDecimal.valueOf(employee.getSalary()));
        return entity;
    }

    public static Employee toDomain(EmployeeEntity entity) {
        if (entity == null) return null;
        return new Employee(
            entity.getId(),
            entity.getName(),
            entity.getLastName(),
            entity.getEmail(),
            entity.getPhone(),
            entity.getPosition(),
            entity.getSpecialty(),
            entity.getSalary() != null ? entity.getSalary().doubleValue() : 0.0
        );
    }
}
