package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;
@Service
public class CreateMedicationItemUseCase {

    private final MedicationItemRepository repository;

    public CreateMedicationItemUseCase(MedicationItemRepository repository) {
        this.repository = repository;
    }

    public MedicationItem execute(MedicationItem item) {
        return repository.save(item);
    }
}