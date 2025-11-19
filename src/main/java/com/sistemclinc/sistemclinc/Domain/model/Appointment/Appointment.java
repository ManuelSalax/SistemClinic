package com.sistemclinc.sistemclinc.Domain.model.Appointment;

import java.time.LocalDateTime;

public class Appointment {

    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime dateTime;
    private String reason;
    private String status; // E.g.: "Scheduled", "Cancelled", "Completed"

    public Appointment(Long id, Long patientId, Long doctorId, LocalDateTime dateTime, String reason, String status) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.reason = reason;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void reschedule(LocalDateTime newDateTime) {
        this.dateTime = newDateTime;
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public void complete() {
        this.status = "Completed";
    }
}
