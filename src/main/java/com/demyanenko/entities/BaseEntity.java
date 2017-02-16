package com.demyanenko.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id = null;
    @Version
    private Long version; // might be useful for client side

    protected BaseEntity() { }
}
