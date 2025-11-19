package com.sistemclinc.sistemclinc.Application.UseCase.Invoice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.InvoiceRepository;
import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;
@Service
public class GetAllInvoicesUseCase {

    private final InvoiceRepository repository;

    public GetAllInvoicesUseCase(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> execute() {
        return repository.findAll();
    }
}