package com.maria.vtbMarket.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public  class ProductsInPurchaseId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer productId;
    private Integer purchaseId;

}
