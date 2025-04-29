package com.decathlon.gifting.jpamapping;

import jakarta.persistence.*;

@Entity
public class CartEntity implements Identifiable {

    @Id
    @SequenceOrAssigned(name = "cart_id_seq", sequenceName = "cart_entity_id_seq", allocationSize = 1)
    private Long id;
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
