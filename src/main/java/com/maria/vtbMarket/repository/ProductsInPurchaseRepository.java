package com.maria.vtbMarket.repository;

import com.maria.vtbMarket.entity.ProductsInPurchase;
import com.maria.vtbMarket.entity.ProductsInPurchaseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsInPurchaseRepository extends JpaRepository<ProductsInPurchase, ProductsInPurchaseId> {
}
