package com.maria.vtbMarket.repository;

import com.maria.vtbMarket.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select customer.customer_id, username, password from customer " +
            " join purchase on customer.customer_id = purchase.customer_id " +
            " where customer.customer_id " +
            " group by customer.customer_id order by count(*) desc limit ?1", nativeQuery = true)
    Set<Customer> getTopBuyers(int limit);



}
