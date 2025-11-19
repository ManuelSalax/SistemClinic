package com.sistemclinc.sistemclinc.Domain.Repository;

import com.sistemclinc.sistemclinc.Domain.model.Order.ProcedureItem;

public interface ProcedureItemRepository {
    ProcedureItem save(ProcedureItem item);
    ProcedureItem findById(Long id);
}
