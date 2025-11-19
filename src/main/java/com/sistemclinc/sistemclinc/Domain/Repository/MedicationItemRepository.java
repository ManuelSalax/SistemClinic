package com.sistemclinc.sistemclinc.Domain.Repository;

import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;

public interface MedicationItemRepository {
    MedicationItem save(MedicationItem item);
    MedicationItem findById(Long id);
}