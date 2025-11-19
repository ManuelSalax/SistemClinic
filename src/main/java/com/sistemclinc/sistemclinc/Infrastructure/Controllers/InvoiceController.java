package com.sistemclinc.sistemclinc.Infrastructure.Controllers;

import com.sistemclinc.sistemclinc.Application.UseCase.Invoice.*;
import com.sistemclinc.sistemclinc.Domain.model.Invoice.Invoice;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final CreateInvoiceUseCase createInvoice;
    private final GetInvoiceByIdUseCase getInvoiceById;
    private final GetAllInvoicesUseCase getAllInvoices;
    private final DeleteInvoiceUseCase deleteInvoice;

    public InvoiceController(
            CreateInvoiceUseCase createInvoice,
            GetInvoiceByIdUseCase getInvoiceById,
            GetAllInvoicesUseCase getAllInvoices,
            DeleteInvoiceUseCase deleteInvoice
    ) {
        this.createInvoice = createInvoice;
        this.getInvoiceById = getInvoiceById;
        this.getAllInvoices = getAllInvoices;
        this.deleteInvoice = deleteInvoice;
    }

    @PostMapping
    public Invoice create(@RequestBody Invoice invoice) {
        return createInvoice.execute(invoice);
    }

    @GetMapping("/{id}")
    public Invoice findById(@PathVariable Long id) {
        return getInvoiceById.execute(id);
    }

    @GetMapping
    public List<Invoice> findAll() {
        return getAllInvoices.execute();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteInvoice.execute(id);
    }
}
