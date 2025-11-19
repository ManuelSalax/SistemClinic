package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.OrderItem.CreateDiagnosticAidItemUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.OrderItem.FindDiagnosticAidItemByIdUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;

@RestController
@RequestMapping("/api/order-items/diagnostic-aid")
public class DiagnosticAidItemController {

    private final CreateDiagnosticAidItemUseCase createUseCase;
    private final FindDiagnosticAidItemByIdUseCase findByIdUseCase;

    public DiagnosticAidItemController(CreateDiagnosticAidItemUseCase createUseCase,
                                       FindDiagnosticAidItemByIdUseCase findByIdUseCase) {
        this.createUseCase = createUseCase;
        this.findByIdUseCase = findByIdUseCase;
    }

    @PostMapping
    public DiagnosticAidItem create(@RequestBody DiagnosticAidItem item) {
        return createUseCase.execute(item);
    }

    @GetMapping("/{id}")
    public DiagnosticAidItem findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }
}
