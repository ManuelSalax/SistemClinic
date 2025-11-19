package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Order.Order;

public interface OrderRepository {

    Order save(Order order);
    Order findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);
}
