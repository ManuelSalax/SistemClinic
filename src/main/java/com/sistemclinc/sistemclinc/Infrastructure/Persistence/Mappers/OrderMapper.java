package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Order.Order;
import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.PatientEntity;

public class OrderMapper {
    public static OrderEntity toPersistence(Order order, PatientEntity patient, EmployeeEntity employee) {
        if (order == null || patient == null || employee == null) return null;
        OrderEntity entity = new OrderEntity();
        entity.setPatient(patient);
        entity.setEmployee(employee);
        entity.setDate(order.getDate());
        // Items mapping not implemented here
        return entity;
    }

    public static Order toDomain(OrderEntity entity, Patient patient, Employee doctor) {
        if (entity == null || patient == null || doctor == null) return null;
        return new Order(
            entity.getId(),
            patient,
            doctor
        );
    }
}
