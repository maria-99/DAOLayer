package com.maria.vtbMarket.repository;

import com.maria.vtbMarket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select p.product_id, p.product_name, p.product_description, p.product_code, p.product_price, p.product_category " +
            "from product as p " +
            "join products_in_purchase on p.product_id = products_in_purchase.product " +
            "group by product " +
            "order by count(*) desc  " +
            "limit ?1", nativeQuery = true)
    Set<Product> getTopProducts(int limit);

}
