package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.MedicationItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;
@Service
public class FindMedicationItemByIdUseCase {

    private final MedicationItemRepository repository;

    public FindMedicationItemByIdUseCase(MedicationItemRepository repository) {
        this.repository = repository;
    }

    public MedicationItem execute(Long id) {
        return repository.findById(id);
    }
}