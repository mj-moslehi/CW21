package model;

import base.entity.BaseEntity;
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

public class Customer extends BaseEntity<Long> {

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    private String nationalId;

    private String phoneNumber;

    private String address;

//    @ElementCollection
//    @CollectionTable(name = "customer_order" ,
//            joinColumns = @JoinColumn(name = "customer_id"))
//    @Column(name = "ordering")
    @OneToMany(cascade = CascadeType.PERSIST)
    private Collection<Ordering> orderings = new ArrayList<>() ;

    public Customer(String firstName, String lastName, Collection<Ordering> orderings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.orderings = orderings;
    }
}
