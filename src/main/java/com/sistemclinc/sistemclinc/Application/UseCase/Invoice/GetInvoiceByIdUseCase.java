package com.sistemclinc.sistemclinc.Application.UseCase.Invoice;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.InvoiceRepository;
import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;
@Service
public class GetInvoiceByIdUseCase {

    private final InvoiceRepository repository;

    public GetInvoiceByIdUseCase(InvoiceRepository repository) {
        this.repository = repository;
    }

    public Invoice execute(Long id) {
        return repository.findById(id);
    }
}
