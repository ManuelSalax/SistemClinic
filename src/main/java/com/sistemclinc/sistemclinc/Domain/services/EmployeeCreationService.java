package com.sistemclinc.sistemclinc.Domain.services;

import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;
import com.sistemclinc.sistemclinc.Domain.model.Security.User;
import com.sistemclinc.sistemclinc.Domain.Repository.EmployeeRepository;
import com.sistemclinc.sistemclinc.Domain.Repository.PatientRepository;
import com.sistemclinc.sistemclinc.Domain.Repository.UserRepository;

public class EmployeeCreationService {
    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public EmployeeCreationService(EmployeeRepository employeeRepository, PatientRepository patientRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    public Employee createEmployee(Employee employee, Patient patient, User user) {
        // Rule 1: No duplicate document (cedula) in patients
        for (Patient existing : patientRepository.findAll()) {
            if (existing.getDocument().equals(patient.getDocument())) {
                throw new IllegalArgumentException("A person with this document already exists");
            }
        }
        // Rule 2: No duplicate username in employees
        for (User existing : userRepository.findAll()) {
            if (existing.getUsername().equals(user.getUsername())) {
                throw new IllegalArgumentException("An employee with this username already exists");
            }
        }
        // Save patient and user first
        patientRepository.save(patient);
        userRepository.save(user);
        // Save employee
        return employeeRepository.save(employee);
    }
}
