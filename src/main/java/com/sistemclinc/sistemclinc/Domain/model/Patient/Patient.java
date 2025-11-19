package com.sistemclinc.sistemclinc.Domain.model.Patient;

import java.time.LocalDate;
import java.util.Objects;

public class Patient {

    private Long id;
    private String name;
    private String lastName;
    private String document;
    private LocalDate birthDate;
    private String phone;
    private String address;

    public Patient(Long id, String name, String lastName, String document,
                    LocalDate birthDate, String phone, String address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
    }

    public int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        return Objects.equals(id, ((Patient) o).id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getDocument() { return document; }
    public LocalDate getBirthDate() { return birthDate; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
}
