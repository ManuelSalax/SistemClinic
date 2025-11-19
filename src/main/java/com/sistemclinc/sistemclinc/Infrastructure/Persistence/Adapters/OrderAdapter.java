package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.PatientEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.EmployeeMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.OrderMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.PatientMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.EmployeeRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.PatientRepositoryJpa;

@Repository
public class OrderAdapter implements OrderRepository {

    private final OrderRepositoryJpa jpa;
    private final PatientRepositoryJpa patientJpa;
    private final EmployeeRepositoryJpa employeeJpa;

    public OrderAdapter(OrderRepositoryJpa jpa,
                        PatientRepositoryJpa patientJpa,
                        EmployeeRepositoryJpa employeeJpa) {

        this.jpa = jpa;
        this.patientJpa = patientJpa;
        this.employeeJpa = employeeJpa;
    }

    // ----------------------------------------------------------------------
    // SAVE
    // ----------------------------------------------------------------------
    @Override
    public Order save(Order order) {

        PatientEntity patientEntity = patientJpa.findById(order.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        EmployeeEntity doctorEntity = employeeJpa.findById(order.getDoctor().getId())
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        OrderEntity entity = OrderMapper.toPersistence(order, patientEntity, doctorEntity);
        OrderEntity saved = jpa.save(entity);

        // Regresamos un Order con Patient y Employee de dominio
        return OrderMapper.toDomain(
                saved,
                PatientMapper.toDomain(patientEntity),
                EmployeeMapper.toDomain(doctorEntity)
        );
    }

    // ----------------------------------------------------------------------
    // FIND BY ID
    // ----------------------------------------------------------------------
    @Override
    public Order findById(Long id) {
        return jpa.findById(id)
                .map(entity -> OrderMapper.toDomain(
                        entity,
                        PatientMapper.toDomain(entity.getPatient()),
                        EmployeeMapper.toDomain(entity.getEmployee())
                ))
                .orElse(null);
    }

    // ----------------------------------------------------------------------
    // FIND ALL
    // ----------------------------------------------------------------------
    @Override
    public List<Order> findAll() {
        return jpa.findAll().stream()
                .map(entity -> OrderMapper.toDomain(
                        entity,
                        PatientMapper.toDomain(entity.getPatient()),
                        EmployeeMapper.toDomain(entity.getEmployee())
                ))
                .toList();
    }

    // ----------------------------------------------------------------------
    // DELETE
    // ----------------------------------------------------------------------
    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
