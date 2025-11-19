package com.sistemclinc.sistemclinc.Domain.model.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Employee.Employee;
import com.sistemclinc.sistemclinc.Domain.model.Patient.Patient;

public class Order {

    private Long id;
    private Patient patient;
    private Employee doctor;
    private final LocalDateTime date;
    private List<OrderItem> items;

    public Order(Long id, Patient patient, Employee doctor) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = LocalDateTime.now();
        this.items = new ArrayList<>();
    }

    // ---------- GETTERS NECESARIOS ----------
    public Long getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    // ---------- FUNCIONES ----------
    public void addItem(OrderItem item) {
        this.items.add(item);
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(OrderItem::getCost).sum();
    }
}
