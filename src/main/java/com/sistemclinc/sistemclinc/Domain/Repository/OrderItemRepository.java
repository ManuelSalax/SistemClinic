package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Order.OrderItem;

public interface OrderItemRepository {
    OrderItem save(OrderItem item);
    List<OrderItem> findByOrderId(Long orderId);
}
