package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;

@Service
public class AddMedicationItemToOrderUseCase {

    private final OrderItemRepository repository;

    public AddMedicationItemToOrderUseCase(OrderItemRepository repository) {
        this.repository = repository;
    }

    public MedicationItem execute(MedicationItem item) {
        return (MedicationItem) repository.save(item);
    }
}