package model;

import base.entity.BaseEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Embeddable

public class Fruit {

    private String name;

    private String description;

    private boolean stock;

    private String weightUnit;

    private int quantity;

    private int pricePerWeight;

    private int canceledPrice;

    private String tag;

    public Fruit(String name) {
        this.name = name;
    }
}
