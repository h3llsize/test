package org.bst.baseservice.entity;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public interface ItemEntity {
    int getPrice();

    String getName();

}
