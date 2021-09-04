package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    @Column(name = "product_code")
    private String code;

    @Column(name = "product_price")
    private double price;

    @JoinColumn(name = "product_category")
    @ManyToOne(fetch = FetchType.EAGER)
    private ProductCategory category;

    @OneToMany(mappedBy = "productInPurchase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProductsInPurchase> productsInPurchases = new HashSet<>();

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                '}';
    }
}
