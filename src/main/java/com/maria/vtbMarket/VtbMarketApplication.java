package com.maria.vtbMarket;

import com.maria.vtbMarket.entity.Product;
import com.maria.vtbMarket.repository.*;
import com.maria.vtbMarket.service.CustomerService;
import com.maria.vtbMarket.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
@EntityScan("com/maria/vtbMarket/entity")
public class VtbMarketApplication {

    public static void main(String[] args) {

        final ConfigurableApplicationContext ctx = SpringApplication.run(VtbMarketApplication.class, args);
    }


}
