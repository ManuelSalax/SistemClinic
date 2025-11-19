package com.sistemclinc.sistemclinc.Application.UseCase.Order;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderRepository;

@Service
public class DeleteOrderUseCase {

    private final OrderRepository repository;

    public DeleteOrderUseCase(OrderRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}