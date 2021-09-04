package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_info")
public class CustomerInfo {

    @Id
    @Column(name = "customer_info_id")
    private int id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_surname")
    private String surname;

    @Column(name = "customer_tel")
    private String telephone;

    @Column(name = "customer_address")
    private String address;

    @JoinColumn(name = "customer_id")
    @OneToOne()
    private Customer customer;

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
