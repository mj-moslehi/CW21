package model;

import base.entity.BaseEntity;
import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Customer extends BaseEntity<Long> {

    @NotNull(message = "not null khodemoon")
    private String firstName;

    private String lastName;

//    @Column(unique = true)
    private String username;

    //@Pattern(regexp = "^((?=\\S*?[A-Z])(?=\\S*?[a-z])(?=\\S*?[0-9]).{6,})\\S$")
    private String password;

//    @Email
    private String email;

    //@Pattern(regexp = "^(\\+98|0)?9\\d{9}$")
    private String phoneNumber;

    private String address;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "customer")
    private Collection<Ordering> orderings = new ArrayList<>();

    public Customer(String firstName, String lastName, String username, String password, String email, String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void addOrdering(Ordering ordering) {
        orderings.add(ordering);
        ordering.setCustomer(this);
    }
}
