package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import com.sistemclinc.sistemclinc.Application.UseCase.Patient.*;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final CreatePatientUseCase createPatient;
    private final GetPatientByIdUseCase getPatientById;
    private final GetAllPatientsUseCase getAllPatients;
    private final UpdatePatientUseCase updatePatient;
    private final DeletePatientUseCase deletePatient;

    public PatientController(
            CreatePatientUseCase createPatient,
            GetPatientByIdUseCase getPatientById,
            GetAllPatientsUseCase getAllPatients,
            UpdatePatientUseCase updatePatient,
            DeletePatientUseCase deletePatient
    ) {
        this.createPatient = createPatient;
        this.getPatientById = getPatientById;
        this.getAllPatients = getAllPatients;
        this.updatePatient = updatePatient;
        this.deletePatient = deletePatient;
    }

    @PostMapping
    public Patient create(@RequestBody Patient patient) {
        return createPatient.execute(patient);
    }

    @GetMapping("/{id}")
    public Patient findById(@PathVariable Long id) {
        return getPatientById.execute(id);
    }

    @GetMapping
    public List<Patient> findAll() {
        return getAllPatients.execute();
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient) {
        return updatePatient.execute(patient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deletePatient.execute(id);
    }
}
