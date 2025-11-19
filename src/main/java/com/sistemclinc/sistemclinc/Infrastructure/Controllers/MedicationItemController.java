package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.OrderItem.CreateMedicationItemUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.OrderItem.FindMedicationItemByIdUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Order.MedicationItem;

@RestController
@RequestMapping("/api/order-items/medication")
public class MedicationItemController {

    private final CreateMedicationItemUseCase createUseCase;
    private final FindMedicationItemByIdUseCase findByIdUseCase;

    public MedicationItemController(CreateMedicationItemUseCase createUseCase,
                                    FindMedicationItemByIdUseCase findByIdUseCase) {
        this.createUseCase = createUseCase;
        this.findByIdUseCase = findByIdUseCase;
    }

    @PostMapping
    public MedicationItem create(@RequestBody MedicationItem item) {
        return createUseCase.execute(item);
    }

    @GetMapping("/{id}")
    public MedicationItem findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }
}
