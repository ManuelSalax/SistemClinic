package com.sistemclinc.sistemclinc.Application.UseCase.Order;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;

@Service
public class FindOrderByIdUseCase {

    private final OrderRepository repository;

    public FindOrderByIdUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public Order execute(Long id) {
        return repository.findById(id);
    }
}
