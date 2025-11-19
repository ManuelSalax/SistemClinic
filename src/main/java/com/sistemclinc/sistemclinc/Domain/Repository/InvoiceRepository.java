package com.sistemclinc.sistemclinc.Domain.Repository;

import java.util.List;

import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;

public interface InvoiceRepository {

    Invoice save(Invoice invoice);
    Invoice findById(Long id);
    List<Invoice> findAll();
    void deleteById(Long id);
}
