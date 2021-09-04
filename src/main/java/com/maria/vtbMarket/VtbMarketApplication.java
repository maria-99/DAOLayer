package com.maria.vtbMarket;

import com.maria.vtbMarket.entity.Product;
import com.maria.vtbMarket.repository.*;
import com.maria.vtbMarket.service.CustomerDemoService;
import com.maria.vtbMarket.service.ProductDemoService;
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
//        List<Ticket> tics = ctx.getBean(CustomerDemoService.class).getTickets(2);
//        Set<Customer> topBuyers = ctx.getBean(CustomerDemoService.class).getTopBuyers(2);
        Set<Product> topProducts = ctx.getBean(ProductDemoService.class).getTopProducts(2);
//        Map<Product, Integer> productQuantityInPurchase = ctx.getBean(ProductDemoService.class).getProductsOfPurchase(1);
        System.out.println(topProducts);
    }

    @Bean
    public CustomerDemoService demoCustomer(CustomerRepository customerRepo) {
        return new CustomerDemoService(customerRepo);
    }

    @Bean
    public ProductDemoService demoProduct(ProductRepository productRepo,
                                          ProductCategoryRepository productCategoryRepo,
                                          PurchaseRepository purchaseRepo,
                                          ProductsInPurchaseRepository productsInPurchaseRepo){
        return new ProductDemoService(productRepo, productCategoryRepo, purchaseRepo, productsInPurchaseRepo);
    }

}
