package com.maria.vtbMarket.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductCategory {

    @Id
    @Column(name = "product_category_id")
    private int id;

    @Column(name = "product_category")
    private String category;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    public ProductCategory(int id, String category) {
        this.id = id;
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductCategory{" + category + '}';
    }
}
