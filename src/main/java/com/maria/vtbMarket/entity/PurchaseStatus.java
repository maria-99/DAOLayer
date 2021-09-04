package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PurchaseStatus {

    @Id
    @Column(name = "purchase_status_id")
    private int id;

    @Column(name = "purchase_status")
    private String status;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchaseList;

    public PurchaseStatus(int id, String status) {
        this.id = id;
        this.status = status;
    }
}
