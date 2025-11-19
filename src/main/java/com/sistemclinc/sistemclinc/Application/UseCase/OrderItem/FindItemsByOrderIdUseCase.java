package com.sistemclinc.sistemclinc.Application.UseCase.OrderItem;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.OrderItemRepository;
import com.sistemclinc.sistemclinc.Domain.model.Order.OrderItem;

@Service
public class FindItemsByOrderIdUseCase {

    private final OrderItemRepository repository;

    public FindItemsByOrderIdUseCase(OrderItemRepository repository) {
        this.repository = repository;
    }

    public List<OrderItem> execute(Long orderId) {
        return repository.findByOrderId(orderId);
    }
}