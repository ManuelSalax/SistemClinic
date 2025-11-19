package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.OrderItem.CreateProcedureItemUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.OrderItem.FindProcedureItemByIdUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;

@RestController
@RequestMapping("/api/order-items/procedure")
public class ProcedureItemController {

    private final CreateProcedureItemUseCase createUseCase;
    private final FindProcedureItemByIdUseCase findByIdUseCase;

    public ProcedureItemController(CreateProcedureItemUseCase createUseCase,
                                   FindProcedureItemByIdUseCase findByIdUseCase) {
        this.createUseCase = createUseCase;
        this.findByIdUseCase = findByIdUseCase;
    }

    @PostMapping
    public ProcedureItem create(@RequestBody ProcedureItem item) {
        return createUseCase.execute(item);
    }

    @GetMapping("/{id}")
    public ProcedureItem findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }
}
