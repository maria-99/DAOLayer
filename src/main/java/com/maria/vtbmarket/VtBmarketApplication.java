package com.maria.vtbmarket;

import com.maria.vtbmarket.dao.CustomerDAO;
import com.maria.vtbmarket.dao.CustomerInfoDAO;
import com.maria.vtbmarket.entity.Customer;
import com.maria.vtbmarket.entity.CustomerInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VtBmarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtBmarketApplication.class, args);
        Customer customer = new Customer();
        CustomerInfo info = new CustomerInfo();
        info.setId(2);
        customer.setId(99);
        customer.setUsername("lea");
        customer.setPassword("pass");
        customer.setInfo(info);
        CustomerDAO c = new CustomerDAO();
        c.create(customer);
    }

}
