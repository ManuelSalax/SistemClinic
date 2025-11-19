package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderItemEntity;

public interface OrderItemRepositoryJpa extends JpaRepository<OrderItemEntity, Long> {

    // 🔹 Consulta todos los items de una orden
    List<OrderItemEntity> findByOrderId(Long orderId);
}
