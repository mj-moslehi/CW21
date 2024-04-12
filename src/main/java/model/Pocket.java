package model;

import base.entity.BaseEntity;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Embeddable

public class Pocket {
    @ManyToOne
    @JoinColumn (name ="orderId")
    private Ordering ordering;
    private String fruitName;
    private Double weight;
    private Double cost;
}
