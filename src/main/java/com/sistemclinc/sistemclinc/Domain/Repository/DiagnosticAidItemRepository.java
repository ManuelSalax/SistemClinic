package com.sistemclinc.sistemclinc.Domain.Repository;

import com.sistemclinc.sistemclinc.Domain.model.Order.DiagnosticAidItem;

public interface DiagnosticAidItemRepository {
    DiagnosticAidItem save(DiagnosticAidItem item);
    DiagnosticAidItem findById(Long id);
}