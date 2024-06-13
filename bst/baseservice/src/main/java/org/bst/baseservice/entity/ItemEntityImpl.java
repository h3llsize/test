package org.bst.baseservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter
public class ItemEntityImpl implements ItemEntity{
    @Id
    private Long id;

    private String name;

    private int price;
}
