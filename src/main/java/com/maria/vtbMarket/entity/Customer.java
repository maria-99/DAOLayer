package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private CustomerInfo info;
//
    @OneToMany(mappedBy = "purchaseCustomer",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Purchase> purchases = new LinkedList<>();

    @OneToMany(mappedBy = "ticketCustomer",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Ticket> tickets = new LinkedList<>();

    public Customer(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
