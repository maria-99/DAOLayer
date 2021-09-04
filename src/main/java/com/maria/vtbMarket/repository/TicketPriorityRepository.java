package com.maria.vtbMarket.repository;

import com.maria.vtbMarket.entity.TicketPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPriorityRepository extends JpaRepository<TicketPriority, Integer> {
}
