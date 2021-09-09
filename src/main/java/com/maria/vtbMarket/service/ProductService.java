package com.maria.vtbMarket.service;

import com.maria.vtbMarket.entity.*;
import com.maria.vtbMarket.repository.ProductCategoryRepository;
import com.maria.vtbMarket.repository.ProductRepository;
import com.maria.vtbMarket.repository.ProductsInPurchaseRepository;
import com.maria.vtbMarket.repository.PurchaseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Transactional
@Service
public class ProductDemoService {

    private ProductRepository productRepository;
    private ProductCategoryRepository productCategoryRepository;
    private PurchaseRepository purchaseRepo;
    private ProductsInPurchaseRepository productsInPurchaseRepo;

    public void deleteProductDemo(int id){
        productRepository.deleteById(id);
    }

    public void deleteProductCategoryDemo(int id){
        productCategoryRepository.deleteById(id);
    }

    public Map<Product, Integer> getProductsOfPurchase(int index){
        Purchase purchase = purchaseRepo.getById(index);
        Set<Product> products = purchase.getPurchaseOfProducts().stream()
                .map(ProductsInPurchase::getProductInPurchase)
                .collect(Collectors.toSet());
        Map<Product, Integer> productsQuantityInPurchase = new HashMap<>();
        for (Product prod: products) {
            int quantity = productsInPurchaseRepo
                    .getById(new ProductsInPurchaseId(prod.getProductId(), index))
                    .getProductQuantity();
            productsQuantityInPurchase.put(prod, quantity);
        }
        return productsQuantityInPurchase;
    }

    public Set<Product> getTopProducts(int limit){
        return productRepository.getTopProducts(limit);
    }

}
