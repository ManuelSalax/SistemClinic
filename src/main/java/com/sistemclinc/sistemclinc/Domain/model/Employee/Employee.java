package com.sistemclinc.sistemclinc.Domain.model.Employee;

import java.util.Objects;

public class Employee {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String position;
    private String specialty;
    private double salary;

    public Employee(Long id, String name, String lastName, String email, String phone,
                    String position, String specialty, double salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.position = position;
        this.specialty = specialty;
        this.salary = salary;
    }

    public Employee(String name, String lastName, String email, String phone,
                    String position, String specialty, double salary) {
        this(null, name, lastName, email, phone, position, specialty, salary);
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getPosition() { return position; }
    public String getSpecialty() { return specialty; }
    public double getSalary() { return salary; }

    public void increaseSalary(double percent) {
        if (percent <= 0) throw new IllegalArgumentException("Invalid percent");
        this.salary += this.salary * (percent / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        return Objects.equals(id, ((Employee) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
