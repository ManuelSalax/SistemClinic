package com.sistemclinc.sistemclinc.Application.UseCase.Invoice;

import org.springframework.stereotype.Service;

import com.sistemclinc.sistemclinc.Domain.Repository.InvoiceRepository;

@Service
public class DeleteInvoiceUseCase {

    private final InvoiceRepository repository;

    public DeleteInvoiceUseCase(InvoiceRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
