package com.maria.vtbMarket.service;

import com.maria.vtbMarket.entity.Customer;
import com.maria.vtbMarket.entity.Ticket;
import com.maria.vtbMarket.repository.CustomerRepository;
import lombok.AllArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Transactional
public class CustomerService {

    //Для тестирования

    private CustomerRepository customerRepository;

    public void addCustomerDemo(){
        customerRepository.save(new Customer(55, "ben", "123"));
    }

    public void deleteCustomerDemo(int i){
        customerRepository.deleteById(i);
    }

    public List<Ticket> getTickets(int i){
        return customerRepository.getById(i).getTickets();
    }

    public Set<Customer> getTopBuyers(int limit){
        return customerRepository.getTopBuyers(limit);
    }

}
