package com.sistemclinc.sistemclinc.Infrastucture.Persistence.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "procedimientos_item")
public class ProcedimientoItemEntity {

    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private ItemOrdenEntity item;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public ItemOrdenEntity getItem() {
        return item;
    }

    public void setItem(ItemOrdenEntity item) {
        this.item = item;
    }
}
