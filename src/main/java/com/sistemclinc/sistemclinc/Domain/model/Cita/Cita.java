package com.sistemclinc.sistemclinc.Domain.model.Cita;

import java.time.LocalDateTime;

public class Cita {

    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime fechaHora;
    private String motivo;
    private String estado; // Ej: "Programada", "Cancelada", "Completada"

    public Cita(Long id, Long pacienteId, Long medicoId, LocalDateTime fechaHora, String motivo, String estado) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void reprogramar(LocalDateTime nuevaFechaHora) {
        this.fechaHora = nuevaFechaHora;
    }

    public void cancelar() {
        this.estado = "Cancelada";
    }

    public void completar() {
        this.estado = "Completada";
    }
}