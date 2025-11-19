package com.sistemclinc.sistemclinc.Application.UseCase.Order;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;

@Service
public class CreateOrderUseCase {

    private final OrderRepository repository;

    public CreateOrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(Order order) {
        return repository.save(order);
    }
}
