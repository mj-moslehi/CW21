package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Ordering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String orderingCode;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String orderingStatus;

    @ElementCollection
    @CollectionTable(name = "pocket",
            joinColumns = @JoinColumn(name = "fruit_id"))
    @Column(name = "pocket_id")
    private Collection<Pocket> pockets = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;

    private String orderingAllCost;

    public Ordering(Customer customer, Collection<Pocket> pockets, DeliveryType deliveryType) {
        this.customer = customer;
        this.pockets = pockets;
        this.deliveryType = deliveryType;
    }
}