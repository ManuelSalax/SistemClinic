package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sistemclinc.sistemclinc.Domain.Repository.AppointmentRepository;
import com.sistemclinc.sistemclinc.Domain.model.Appointment.Appointment;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.AppointmentEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.PatientEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.AppointmentMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.EmployeeRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.PatientRepositoryJpa;

@Component
public class AppointmentJpaAdapter implements AppointmentRepository {

    private final com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.AppointmentRepositoryJpa appointmentJpa;
    private final PatientRepositoryJpa patientJpa;
    private final EmployeeRepositoryJpa employeeJpa;

    public AppointmentJpaAdapter(
            com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.AppointmentRepositoryJpa appointmentJpa,
            PatientRepositoryJpa patientJpa,
            EmployeeRepositoryJpa employeeJpa
    ) {
        this.appointmentJpa = appointmentJpa;
        this.patientJpa = patientJpa;
        this.employeeJpa = employeeJpa;
    }

    @Override
    public Appointment save(Appointment appointment) {

        // Obtener PatientEntity
        PatientEntity patient = patientJpa.findById(appointment.getPatientId())
                .orElseThrow(() -> new RuntimeException("❌ Paciente no encontrado: " + appointment.getPatientId()));

        // Obtener Doctor (EmployeeEntity)
        EmployeeEntity doctor = employeeJpa.findById(appointment.getDoctorId())
                .orElseThrow(() -> new RuntimeException("❌ Médico no encontrado: " + appointment.getDoctorId()));

        // Convertir dominio → entidad
        AppointmentEntity entity = AppointmentMapper.toEntity(appointment, patient, doctor);

        // Guardar
        AppointmentEntity saved = appointmentJpa.save(entity);

        // Retornar entidad → dominio
        return AppointmentMapper.toDomain(saved);
    }

    @Override
    public Appointment findById(Long id) {
        Optional<AppointmentEntity> entity = appointmentJpa.findById(id);
        return entity.map(AppointmentMapper::toDomain).orElse(null);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentJpa.findAll()
                .stream()
                .map(AppointmentMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        appointmentJpa.deleteById(id);
    }
}
