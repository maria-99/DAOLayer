package com.maria.vtbMarket.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    private int purchaseId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer purchaseCustomer;

    @Column(name = "purchase_date")
    private Date date;

    @Column(name = "delivery_info")
    private String deliveryInfo;

    @Column(name = "payment_sum")
    private double paymentSum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_status")
    private PurchaseStatus status;

    @OneToMany(mappedBy = "purchaseOfProduct", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ProductsInPurchase> purchaseOfProducts = new HashSet<>();

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", purchaseCustomer=" + purchaseCustomer +
                ", date=" + date +
                ", deliveryInfo='" + deliveryInfo + '\'' +
                ", paymentSum=" + paymentSum +
                ", status=" + status +
                '}';
    }
}
