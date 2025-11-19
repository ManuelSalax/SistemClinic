package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemclinc.sistemclinc.Application.UseCase.Order.CreateOrderUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Order.DeleteOrderUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Order.FindAllOrdersUseCase;
import com.sistemclinc.sistemclinc.Application.UseCase.Order.FindOrderByIdUseCase;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final CreateOrderUseCase createUseCase;
    private final FindOrderByIdUseCase findByIdUseCase;
    private final FindAllOrdersUseCase findAllUseCase;
    private final DeleteOrderUseCase deleteUseCase;

    public OrderController(CreateOrderUseCase createUseCase,
                           FindOrderByIdUseCase findByIdUseCase,
                           FindAllOrdersUseCase findAllUseCase,
                           DeleteOrderUseCase deleteUseCase) {

        this.createUseCase = createUseCase;
        this.findByIdUseCase = findByIdUseCase;
        this.findAllUseCase = findAllUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    // ============================================================
    // CREATE
    // ============================================================
    @PostMapping
    public Order create(@RequestBody Order order) {
        return createUseCase.execute(order);
    }

    // ============================================================
    // GET BY ID
    // ============================================================
    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return findByIdUseCase.execute(id);
    }

    // ============================================================
    // GET ALL
    // ============================================================
    @GetMapping
    public List<Order> findAll() {
        return findAllUseCase.execute();
    }

    // ============================================================
    // DELETE
    // ============================================================
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUseCase.execute(id);
    }
}