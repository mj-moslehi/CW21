package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String OrderingCode;

    private String OrderingOwner;

    private String OrderingStatus;

    @ElementCollection
    @CollectionTable(name = "ordering_fruit",
            joinColumns = @JoinColumn(name = "fruit_id"))
    @Column(name = "order")

    private Collection<Fruit> fruits = new ArrayList<>();

    private String OrderingType;

    private String OrderingAllCost;

    public Ordering(String orderingOwner, Collection<Fruit> fruits) {
        OrderingOwner = orderingOwner;
        this.fruits = fruits;
    }
}