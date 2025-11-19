package com.sistemclinc.sistemclinc.Application.UseCase.Invoice;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.InvoiceRepository;
import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;

@Service
public class CreateInvoiceUseCase {

    private final InvoiceRepository repository;

    public CreateInvoiceUseCase(InvoiceRepository repository) {
        this.repository = repository;
    }

    public Invoice execute(Invoice invoice) {
        return repository.save(invoice);
    }
}
