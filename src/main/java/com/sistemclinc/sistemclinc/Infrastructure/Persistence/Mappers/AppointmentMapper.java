package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers;

import com.sistemclinc.sistemclinc.Domain.model.Appointment.Appointment;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.AppointmentEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.PatientEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.EmployeeEntity;

public class AppointmentMapper {

    /**
     * 🔹 Convierte dominio → entidad JPA
     * Este método NO crea PatientEntity ni DoctorEntity,
     * solo los inserta cuando el adapter ya los obtuvo.
     */
    public static AppointmentEntity toEntity(Appointment appointment, PatientEntity patient, EmployeeEntity doctor) {
        if (appointment == null) return null;

        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(appointment.getId()); // por si se actualiza
        entity.setPatient(patient);
        entity.setDoctor(doctor);
        entity.setDateTime(appointment.getDateTime());
        entity.setReason(appointment.getReason());
        entity.setStatus(appointment.getStatus());

        return entity;
    }

    /**
     * 🔹 Convierte entidad JPA → dominio
     */
    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) return null;

        return new Appointment(
                entity.getId(),
                entity.getPatient() != null ? entity.getPatient().getId() : null,
                entity.getDoctor() != null ? entity.getDoctor().getId() : null,
                entity.getDateTime(),
                entity.getReason(),
                entity.getStatus()
        );
    }
}
