package com.demyanenko.core;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Version
    private Long version; // might be useful for client side

    protected BaseEntity() {
        id = null;
    }
}
