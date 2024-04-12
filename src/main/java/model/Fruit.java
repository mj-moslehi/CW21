package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity

public class Fruit extends BaseEntity<Long> {

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
