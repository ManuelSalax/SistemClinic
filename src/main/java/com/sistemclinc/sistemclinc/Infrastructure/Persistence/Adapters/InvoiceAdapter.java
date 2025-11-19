package com.sistemclinc.sistemclinc.Infrastructure.Persistence.Adapters;

import com.sistemclinc.sistemclinc.Domain.Repository.InvoiceRepository;
import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;
import com.sistemclinc.sistemclinc.Domain.model.Order.Order;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.InvoiceEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Entity.OrderEntity;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Mappers.InvoiceMapper;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.InvoiceRepositoryJpa;
import com.sistemclinc.sistemclinc.Infrastructure.Persistence.Repository.OrderRepositoryJpa;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InvoiceAdapter implements InvoiceRepository {

    private final InvoiceRepositoryJpa jpa;
    private final OrderRepositoryJpa orderJpa;

    public InvoiceAdapter(InvoiceRepositoryJpa jpa, OrderRepositoryJpa orderJpa) {
        this.jpa = jpa;
        this.orderJpa = orderJpa;
    }

    @Override
    public Invoice save(Invoice invoice) {

        Order order = invoice.getOrder();

        // Buscar OrderEntity
        OrderEntity orderEntity = orderJpa.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));

        InvoiceEntity entity = InvoiceMapper.toPersistence(invoice, orderEntity);

        InvoiceEntity saved = jpa.save(entity);

        return InvoiceMapper.toDomain(saved, order);
    }

    @Override
    public Invoice findById(Long id) {
        return jpa.findById(id)
                .map(entity ->
                        InvoiceMapper.toDomain(
                                entity,
                                new Order(entity.getOrder().getId(), null, null)
                        )
                )
                .orElse(null);
    }

    @Override
    public List<Invoice> findAll() {
        return jpa.findAll().stream()
                .map(entity ->
                        InvoiceMapper.toDomain(
                                entity,
                                new Order(entity.getOrder().getId(), null, null)
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
