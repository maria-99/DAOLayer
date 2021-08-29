package com.maria.vtbmarket.entity;

public class ProductsInPurchase {

    private Purchase purchase;
    private Product product;
    private int productQuantity;

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "ProductsInPurchase{" +
                "purchase=" + purchase +
                ", product=" + product +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
