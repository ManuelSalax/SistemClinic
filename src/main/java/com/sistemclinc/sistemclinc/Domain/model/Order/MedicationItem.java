package com.sistemclinc.sistemclinc.Domain.model.Order;

import com.sistemclinc.sistemclinc.Domain.model.Inventory.Medication;

public class MedicationItem extends OrderItem {

    private Medication medication;
    private int quantity;

    public MedicationItem(Long id,Long orderId, String name, double cost, Medication medication, int quantity) {
        super(id,orderId, name, cost);
        this.medication = medication;
        this.quantity = quantity;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateCost() {
        return medication.getPrice() * quantity;
    }
}
