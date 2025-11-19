package com.sistemclinc.sistemclinc.Application.UseCase.Order;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;

@Service
public class FindAllOrdersUseCase {

    private final OrderRepository repository;

    public FindAllOrdersUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> execute() {
        return repository.findAll();
    }
}
