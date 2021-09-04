package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ProductsInPurchase {

    @EmbeddedId
    private ProductsInPurchaseId id = new ProductsInPurchaseId();

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase")
    @MapsId("purchaseId")
    private Purchase purchaseOfProduct;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product")
    @MapsId("productId")
    private Product productInPurchase;

    @Column(name = "product_quantity")
    private int productQuantity;

}
